//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.chd.HibernateSessionFactory;
import org.chd.MisConstants;
import org.chd.entity.TeacherInfo;
import org.chd.tea.TeaConstants;
import org.chd.tea.struts.form.SendMailForm;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** 
 * MyEclipse Struts
 * Creation date: 04-20-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class SendMailAction extends Action {

	// --------------------------------------------------------- Instance Variables

	// --------------------------------------------------------- Methods

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {
		
		
		if (isCancelled(request)) {
			return mapping.findForward("suc");
		}
		
		if(isTokenValid(request,true)){
			
			SendMailForm smf = (SendMailForm) form;
			HttpSession hs = request.getSession();
			hs.removeAttribute(TeaConstants.STU_ID);
			Session s = HibernateSessionFactory.getSession();
			Transaction tx=null;
			
			try{

				tx=s.beginTransaction();
			    String to = smf.getEmail();
			    
			    System.out.println(to);

			    String host = "mail.chd.edu.cn";
			    String from = "CAMIS";
			    String cont =smf.getContent();
			    
				TeacherInfo tea = (TeacherInfo)hs.getAttribute(MisConstants.TEACHERINFO_KEY);
			    String teaName=tea.getTeacherName();
			    String teaPhone=tea.getTeacherPhone();
			    String teaEmail=tea.getTeacherEmail();
			    String stuName=hs.getAttribute(TeaConstants.STU_NAME).toString();
			    hs.removeAttribute(TeaConstants.STU_NAME);
			    StringBuffer content = new StringBuffer();
			    content.append("*** 这是自动消息，请勿回复***\n\n");
			    content.append(stuName);
			    content.append(", 你好,你的毕业设计开题报告没有通过审查,下面是 ");
			    content.append(teaName);
			    content.append(" 老师的联系方式和暂缓开题原因, 请尽快修改:\n\n");
			    content.append("电话:");
			    content.append(teaPhone);
			    content.append("\n\nE-mail:");
			    content.append(teaEmail);
			    content.append("\n\n\n\n------------------------------------------\n暂缓原因:\n\n");
			    content.append(cont);
			    content.append("\n------------------------------------------\n\n\n\n");
			    //new properties
			    Properties props = new Properties();
			    //Setup mail server
			    props.put("mail.smtp.host", host);//设置smtp主机
			    props.put("mail.smtp.auth","true");//使用smtp身份验证
			    //Get session
			    javax.mail.Session session = javax.mail.Session.getDefaultInstance(props, null);
			    MimeMessage message = new MimeMessage(session);
			    message.setFrom(new InternetAddress(from));
			    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			    message.setSubject("毕业设计暂缓开题通知");
			    message.setText(content.toString());
			    System.out.println(content);
			    message.saveChanges();
			    //Send message
			    Transport transport = session.getTransport("smtp");
			    System.out.println("正在连接"+host);
			   
			    transport.connect(host,"wuyang","camis2simac");
		
			    System.out.println("正在发送给"+to);
			    transport.sendMessage(message, message.getAllRecipients());
			    System.out.println("邮件发送成功");
			    resetToken(request);
			    tx.commit();
			}catch(javax.mail.SendFailedException sf){
	        	ActionErrors errors = new ActionErrors();
	        	errors.add("sendFail",new ActionError("error.mail.sendfail"));
	        	this.saveErrors(request,errors);
	        	saveToken(request);
	        	return mapping.getInputForward();
			}catch(Exception e){
				if(tx!=null){tx.rollback();}
				e.printStackTrace();
				return mapping.findForward("failure");
			}finally{
				s.close();
			}
			ActionMessages msg = new ActionMessages();
			msg.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("message.sendMailSUC"));
			this.saveMessages(request,msg);
			return mapping.findForward("suc");
		
		}else{
        	ActionErrors errors = new ActionErrors();
        	errors.add("submitagain",new ActionError("error.submitagain"));
        	this.saveErrors(request,errors);
        	saveToken(request);
        	return mapping.getInputForward();
		}
		
	}

}

