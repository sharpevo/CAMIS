package org.chd.tea;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.chd.tea.TeaConstants;
import org.apache.commons.digester.Digester;
import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.RequestProcessor;
import org.apache.struts.config.ActionConfig;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.config.ModuleConfigFactory;
import org.chd.tea.TeaActionMapping;
import javax.swing.tree.DefaultMutableTreeNode;

//import fr.improve.struts.taglib.layout.crumb.CrumbImpl;
/**
 * Description:用于Struts的访问控制，规定用户的行为，即用户只能通过页面链接进行操作，任何手工输入地址
 * 产生的访问，都为非法，跳转至warning界面。
 * 
 * 为每位用户建立viewStack，即breadCrumb，用于保存用户的行踪和作为是否授权的判断依据。
 * 
 * 每个访问到达，都须经过若干工序的排查和处理，流程见论文第九章。
 * 
 * 为防止同一用户“以较快速度”发送多个请求（具备同一sessionID的request）带来的干扰，例如
 * 用户的BreadCrumb为A->B->C，在C处的用户，“同时”产生了一个前进请求即request D，和一个后退请求即request A
 * 假设requestA先到达，正在排查的时候，request D到达，那么即使用户成功的回到A点，那么在处理BreadCrumb之前
 * 用户的requestD却是合法的。
 * 因此，需要对session进行加锁，考虑多个加锁方法之后（见翻译第一篇），选择synchronize（）块加锁，性能为：
 * 对于同一用户的请求，我们规定其只能“逐一”进行排查，即第一个请求处理完之前（离开synchronize块），第二个请求
 * 不允许进入处理流程。而不同用户的请求还是可以“并行”操作的。
 * 
 * <preAction>:为每个Action都设置了入口要求，即只有在PreAction列表（在程序中为list）的Action才能通过请求。
 * 		像teaEntry，没有入口要求的Action，流程入口即可排除，不必执行后续处理，提高请求通过率。
 * <toCrumb>:考虑到链末端Action或入口Action(如teaEntry)等不需要存入用户BreadCrumb列表的Action，设置此属性，默认为false
 * 		在JSP页面通过<app:showCrumb >标签来实现显示用户踪迹。需要加上<%@ taglib uri="/chdTag" prefix="app"%>，在WEB-INF中
 * 		添加app.tld。需要定义properties文件，例如LabelResources中的action.censorReport，当系统为中文时，显示“审查开题报告”；
 * 		英文时显示"Censor Report"
 * 
 * 
 * 在struts-config-tea.xml中注册，如下：
 * <controller processorClass="org.chd.tea.TeaRequestProcessor"/>
 * 另外还要重写ActionMapping来获得更多的Action属性，在配置文件中，还要注册自定义的ActionMapping类TeaActionMapping
 * <action-mappings type="org.chd.tea.TeaActionMapping">
 * 
 * 
 * 
 * 最后，如果觉得这个功能不好，可以这样卸载，很简单：
 * <controller processorClass="org.chd.tea.TeaRequestProcessor"/>
 * 如果要清干净，还要删除每个Action的<set-property>属性 
 * 
 */
public class TeaRequestProcessor extends RequestProcessor{
	
	/**
	 * 从request中取得URI或URL关键字
	 * E.g. xxx/censorReport.do => censorReport
	 * @param str
	 * @return
	 */
	protected String getReqKey(String str){
		String[] ur = str.split("/|\\.");
		return ur[ur.length-2];
	}
	
	/**
	 * 从用户BreadCrumb中取得Crumb关键字
	 * E.g. action.censorReport =>censorReport
	 * @param crumb
	 * @return
	 */
	protected String getCrumbKey(Map crumb){
		String[] crumbName=crumb.get(TeaConstants.CRUMBKEY).toString().split("\\.");
		return crumbName[crumbName.length-1].toString();
	}
	
	/**
	 * 判断此Action是否为ActionForward，依据struts配置文件中取得当前Action的type属性
	 * @param type
	 * @return
	 */
	protected boolean isActionForward(String type){

		return "org.apache.struts.actions.ForwardAction".equals(type);
	}
	
	/**
	 * 通过前缀(beginWith)、后缀(endWith)来组合String。
	 * E.g. str=censorReport, beginWith=action, endWith="" =>action.censorReport
	 * E.g. str=censorReport, beginWith=/, endwith=.do =>/censorReport.do
	 * @param str
	 * @param beginWith
	 * @param endWith
	 * @return
	 */
	protected String buildString(String str,String beginWith,String endWith){
		StringBuffer aString=new StringBuffer(beginWith);
		aString.append(str);
		if(!endWith.equals("")){
			aString.append(endWith);
		}
		return aString.toString();
	}
	
	/**
	 * 判断当前请求是否为Validation出错，即此时系统处于通过了本权限验证，在进入Action之前的阶段出现错误
	 * 通过判断请求URI关键字与当前Action的input的属性一致即可
	 * @param URIkey
	 * @param input
	 * @return
	 */
	protected boolean isValidationRequest(String URIkey,String input){
		
		return URIkey.equals(input);
	}
	
	/**
	 * 从用户BreadCrumb的末端移除一个踪迹，即删除最后一个crumb的key，和前一个crumb的link
	 * E.g. 在JSP中，显示为"（教师首页）>（我的课题）>填写任务书",括号表示有链接，可以点击。
	 * 		用户后退一次，应删除"填写任务书"这个key和"我的课题"的link.最后变为
	 * 		"（教师首页）>我的课题"
	 * @param crumbs
	 */
	protected void crumbRemoveOne(List crumbs){
		Map crumb = new HashMap();
		crumb = (Map) crumbs.get(crumbs.size()-2);
		crumb.put(TeaConstants.CRUMBLINK, null);
		crumbs.remove(crumbs.size()-1);
		
	}
	
	/**
	 * 从起始点(startPoint)开始移除此后所有的crumb
	 * E.g. 在JSP中，显示为"（教师首页）>（我的课题）>填写任务书",括号表示有链接，可以点击。
	 * 		用户后退至"教师首页"，应删除其后的所有crumb，最后变为
	 * 		"教师首页"
	 * @param crumbs
	 * @param startPoint
	 */
	protected void crumbRemoveMore(List crumbs,int startPoint){
		for(int i=crumbs.size()-1;i>startPoint;i--){
			crumbRemoveOne(crumbs);
		}
	}

	/**
	 * 添加一个Crumb,即由当前Crumb的key生成一个Link保存，再增加一个正在处理的Action的key，而不要
	 * 设置它的Link
	 * E.g. 在JSP中，显示为"（教师首页）>我的课题",此时，用户点击填写任务书，就要为"我的课题"添加链接，
	 * 并且在气候添加一个"填写任务书"没有Link的key。
	 * @param crumbs
	 * @param URIkey
	 * @return
	 */
	protected List crumbAddOne(List crumbs,String URIkey){
		Map crumb = new HashMap();
		crumb = (Map) crumbs.get(crumbs.size()-1);
		crumb.put(TeaConstants.CRUMBLINK, buildString(getCrumbKey(crumb),"/tea/",".do"));
		crumb = new HashMap();
		crumb.put(TeaConstants.CRUMBKEY, buildString(URIkey,"action.",""));
		crumbs.add(crumb);
		return crumbs;
	}

	
	/**
	 * 用于为没有Crumb的用户创建一个，通常为用户第一次进入的时候调用。
	 * @param crumbs
	 * @param URIkey
	 * @return
	 */
	protected List crumbCreateOne(List crumbs,String URIkey){
		Map crumb = new HashMap();
		crumbs = new ArrayList();
		crumb.put(TeaConstants.CRUMBKEY, "action."+URIkey);
		crumbs.add(crumb);
		return crumbs;
	}
	
	/**
	 * 将当前Crumb和Action中PreAction列表中的每一项进行对比，如果匹配，则为合法
	 * 否则，非法。
	 * @param crumbs
	 * @param preActions
	 * @return
	 */
	protected boolean isMatched(List crumbs,List preActions){
		Map crumb = new HashMap();
		crumb = (Map)crumbs.get(crumbs.size()-1); // 取得当前的crumb
		// 循环匹配
		boolean flag = false;
		for(int i=0;i<preActions.size();i++){
			//if(preActions.get(i).equals(crumb.get(TeaConstants.CRUMBKEY))){
			String preAction = preActions.get(i).toString();
			String crumbKey = crumb.get(TeaConstants.CRUMBKEY).toString();
																	if(log.isInfoEnabled()){
																		log.info("<<Check>>---For: Crumb '"+crumbKey+"' == preAction '"+preAction+"'");
																	}
			if(preAction.equals(crumbKey)){
				flag = true;
				break;
			}
		}
		
		
		return flag;

	}
	
	/*
	 * 重写process方法
	 * @see org.apache.struts.action.RequestProcessor#process(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */

	public void process(HttpServletRequest request, 
    		HttpServletResponse response)
    		throws IOException, ServletException {
    									
		
		request = processMultipart(request);
		
		// Identify the path component we will use to select a mapping
		String path = processPath(request, response);
		if (path == null) {
		return;
		}
		if (log.isDebugEnabled()) {
		log.debug("Processing a '" + request.getMethod() +
		          "' for path '" + path + "'");
		}
		
		// Select a Locale for the current user if requested
		processLocale(request, response);
		
		// Set the content type and no-caching headers if requested
		processContent(request, response);
		processNoCache(request, response);
		
		// General purpose preprocessing hook
		if (!processPreprocess(request, response)) {
		return;
		}
		
		// Identify the mapping for this request
		ActionMapping mapping = processMapping(request, response, path);
		if (mapping == null) {
		return;
		}
																if (log.isDebugEnabled()) {
																	log.debug("Mapping a '" + mapping.getPath());
																	}
		/*
		 * 开始验证
		 * 
		 * 
		 * 
		 */

		//hs.removeAttribute(TeaConstants.CRUMBS_KEY);
																if(log.isInfoEnabled()){
																	log.info("开始校验路径\n---<<正在处理>>---");
																}
        
        /* More Easily in Struts 1.1 which not need to Cast
         * String[] mappings = servlet.getServletContext().getAttribute(Globals.MAPPINGS_KEY);
         */
																
		
																
																
																
		/*
		
		树，模仿Continuation的用户森林，而不采用其类似阻塞的方法。
		这样可以不用动态的为用户生成一个BreadCrumb，而是我们自己制定一个站点地图，只要在每个
		站点为保存一个用户ID，即可跟踪用户状态，效率和资源占用要比这个方法高，而且，用户的行为也被
		自然的限制在了一个森林的一颗树内，方便合理。
		有向图更好一点，这个方法就是类似于图的存储中的边表结构。
		try。。。
		
		DefaultMutableTreeNode root;
		DefaultMutableTreeNode child;
		
		root = new DefaultMutableTreeNode("action.teaEntry");
		
		ActionConfig acs[] = this.moduleConfig.findActionConfigs();
		for(Object action:acs){
			System.out.println(((ActionMapping)action).getPath());// show all the Action in TeaStruts config file.
		}
		*/
		
		
		
 
		String URIkey = getReqKey(request.getRequestURI());
		String URLkey = getReqKey(request.getRequestURL().toString());
																if(log.isInfoEnabled()){
																	log.info("<<准备>>---获取请求URL= '"+URLkey+"' 和URI= '"+URIkey+"' ");
																}	
		TeaActionMapping teaAM = (TeaActionMapping) mapping;
		Vector preActions = teaAM.getPreActions();
		boolean toCrumb = true;
		toCrumb = teaAM.isToCrumb();
		HttpSession session = request.getSession();
		
		/*
		 * 加锁
		 */
		synchronized(session){
																if(log.isInfoEnabled()){
																	log.info("<<开始>>---进入线程同步区");
																}	
			List crumbs = (List) session.getAttribute(TeaConstants.CRUMBS_KEY);

			// 判断是否为actionForward
																if(log.isInfoEnabled()){
																	log.info("<<Step I >>---Process:正在校验是否为ActionForward请求");
																}	
			if(isActionForward(mapping.getType())){
																if(log.isInfoEnabled()){
																	log.info("<<Step I >>---Result:是ActionForward请求");
																	log.info("<<Step I >>---Process:正在校验是否为Validation出错返回请求");
																}
				// action 是否是validation验证的返回
				if(isValidationRequest(buildString(URIkey,"/",".do"),
						processMapping(request, response, buildString(URLkey,"/","")).getInput())){
																if(log.isInfoEnabled()){
																	log.info("<<Step I >>---Result:是Validation出错返回请求");
																	log.info(">>>>>>>>>>>>>>>>>>>>>放行!!!\n---<<处理完毕>>---");

																	
																}
				}else{
					// 是一个actionforward但又不是validation返回,那肯定是一个普通的跳转actionmapping
																if(log.isInfoEnabled()){
																	log.info("<<Step I >>---Result:不是Validation出错返回请求");
																	log.info("<<Step I >>---Process:此请求为普通的JSP页面请求,正在校验入口匹配");
																}
					if(isMatched(crumbs,preActions)){
																if(log.isInfoEnabled()){
																	log.info("<<Step I >>---Result:入口匹配");
																	log.info(">>>>>>>>>>>>>>>>>>>>>放行!!!\n---<<处理完毕>>---");
																}
					}else{
																if(log.isInfoEnabled()){
																	log.info("<<Step I >>---Result:入口不匹配,非法访问");
																	log.info("xxxxxxxxxxxxxxxxxxxxx转至出错页面......\n---<<处理完毕>>---");
																	System.out.println("	xxxxxx入口不匹配,非法访问	"+session.getId());
																}
						processForwardConfig(request, response, teaAM.findForward("illegalAccess"));
						return;
					}
				}
			}else{
																if(log.isInfoEnabled()){
																	log.info("<<Step I >>---Result: 不是ActionForward请求");
																	log.info("<<Step II >>---Process: 此请求为Action请求,判断方向");
																}				
				if(crumbs != null){
																if(log.isInfoEnabled()){
																	log.info("<<Step II >>---Result: 具备Crumbs");
																	log.info("<<Step II >>---Process: 判断是否回退");
																}
					String crumbKey="";
					boolean isBackward=false;
																if(log.isInfoEnabled()){
																	log.info("<<Step II >>---Process: 遍历Crumbs,判断请求入口是否在用户Crumbs中");
																}	
					for(int j=0;j<crumbs.size();j++){
						Map crumb1 = (Map) crumbs.get(j);
						crumbKey = getCrumbKey(crumb1);
						if(URIkey.equals(crumbKey)){
																if(log.isInfoEnabled()){
																	log.info("<<Step II >>---Result: 遍历Crumbs No."+j+",此请求为回退");
																	log.info(">>>>>>>>>>>>>>>>>>>>>放行!!!\n---<<处理完毕>>---");
																}							
							crumbRemoveMore(crumbs,j);
							isBackward=true;
							break;
						}else{
																if(log.isInfoEnabled()){
																	log.info("<<Step II >>---Result: 遍历Crumbs No."+j+",未匹配");
																}	
						}
					}
				
					if(!isBackward){
																if(log.isInfoEnabled()){
																	log.info("<<Step II >>---Result: 用户请求方向为前进");
																}	
						//不是回退,为前进
						if(!preActions.isEmpty()){
							// 对入口有要求,应该验证
																if(log.isInfoEnabled()){
																	log.info("<<Step II >>---Process: 此Action要求入口验证,正在进行入口校验");
																}
							if(isMatched(crumbs,preActions)){
																if(log.isInfoEnabled()){
																	log.info("<<Step II >>---Result: 当前crumbs和入口匹配");
																}
							}else{
																if(log.isInfoEnabled()){
																	log.info("<<Step II >>---Result: 当前crumbs和入口不匹配非法访问");
																	log.info("xxxxxxxxxxxxxxxxxxxxx转至出错页面......\n---<<处理完毕>>---");
																	System.out.println("	xxxxxx当前crumbs和入口不匹配非法访问	"+session.getId());
																}
								processForwardConfig(request, response, teaAM.findForward("illegalAccess"));
								return;
							}
						}else{
							if(log.isInfoEnabled()){
								log.info("<<Step II >>---Process: 此Action不要求入口验证");
							}
							
							
						}
						// 不论有无要求,既然前进,就要判断是否留下痕迹
																if(log.isInfoEnabled()){
																	log.info("<<Step III >>---Process: 判断是否添加此步至Crumbs");
																}
						if(toCrumb){
																if(log.isInfoEnabled()){
																	log.info("<<Step III >>---Result: 根据struts-config配置,将此步添加进Crumbs");
																	log.info(">>>>>>>>>>>>>>>>>>>>>放行!!!\n---<<处理完毕>>---");
																}
							crumbs = crumbAddOne(crumbs,URIkey);
							session.removeAttribute(TeaConstants.CRUMBS_KEY);
							session.setAttribute(TeaConstants.CRUMBS_KEY, crumbs);
						}else{
																if(log.isInfoEnabled()){
																	log.info("<<Step III >>---Result: 忽略此步,未添加进Crumbs");
																	log.info(">>>>>>>>>>>>>>>>>>>>>放行!!!\n---<<处理完毕>>---");
																}
						}
					}
				}else{
																if(log.isInfoEnabled()){
																	log.info("<<Step II >>---Result: 无Crumbs,可能为第一次进入系统");
																	log.info(">>>>>>>>>>>>>>>>>>>>>放行!!!\n---<<处理完毕>>---");
																}
					// 无状态,保存crumbs,退出
					if(preActions.isEmpty()){
						//无入口要求，验证是否记录
						/*
						 *保守的，要求除endNode和ActionChain以外的所有Action都要设置入口要求并且记录
						 *无preAction的一般为入口 
						 *
						 *当然，如果没有设置preAction要求，则把此Action暴露在机制之外，那么
						 *第一，toCrumb=false，用户不会获得一个Crumb，比如TeaEntryAction
						 *第二，tocrumb=true，用户会获得一个Crumb，那么只有toCrumb属性而没有preAction属性的Action是不建议的，
						 *		退一步，如果真的有toCrumb和无preAction，维护人员的目的应该是在用户进入，就为其创建一个Crumb
						 *		
						 *如果没有添加toCrumb，则认为不添加Crumb，那么用户只有通过“中规中矩”的访问，才能获得合法身份
						 *
						 *
						 */
						if(toCrumb){
							crumbs = crumbCreateOne(crumbs,URIkey);
						}
					}else{
						
						/*
						 * 如果用户另开一个浏览器，我们认为是不同的用户，那么此时的状态是：
						 * 用户无crumb，访问任何一个Action
						 * 对这一特例也要考虑
						 * 
						 * 为防止用户无状态的访问枷锁的Action，而非法获得Crumb，我们这里要保证用户的访问要求是否为
						 */
						//有入口要求，按规则，用户不可能无状态而进入又访问有入口要求的Action，必为非法访问
						System.out.println("	xxxxxxEnd	"+session.getId());	
						processForwardConfig(request, response, teaAM.findForward("illegalAccess"));
						return;
					}
					
					session.removeAttribute(TeaConstants.CRUMBS_KEY);
					session.setAttribute(TeaConstants.CRUMBS_KEY, crumbs);
				}	
				
			}
			System.out.print(session.getId()+": ");
			for(Object object:crumbs){
				System.out.print(object+"-->");
			}
			//System.out.println("\n--------------------------------------------------------------------\n");// test MultiAction
		}
		

		// Check for any role required to perform this action
		if (!processRoles(request, response, mapping)) {
		return;
		}

		// Process any ActionForm bean related to this request
		ActionForm form = processActionForm(request, response, mapping);
		processPopulate(request, response, form, mapping);
		if (!processValidate(request, response, form, mapping)) {
		return;
		}

		// Process a forward or include specified by this mapping
		if (!processForward(request, response, mapping)) {
		return;
		}
		if (!processInclude(request, response, mapping)) {
		return;
		}

		// Create or acquire the Action instance to process this request
		Action action = processActionCreate(request, response, mapping);
		if (action == null) {
		return;
		}

		// Call the Action instance itself
		ActionForward forward =
		processActionPerform(request, response,
		                     action, form, mapping);

		// Process the returned ActionForward instance
		processForwardConfig(request, response, forward);
		
		
	}
		

		
}
