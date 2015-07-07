//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.chd.tea.TeaConstants;

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
import org.chd.entity.LevelA;
import org.chd.entity.LevelAId;
import org.chd.entity.TeacherInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** 
 * MyEclipse Struts
 * Creation date: 12-20-2006
 * 
 * XDoclet definition:
 * @struts.action path="/psPre" name="psPreForm" input="/psPre.jsp" scope="request" validate="true"
 * @struts.action-forward name="suc" path="aa" redirect="true"
 */
public class PsPreAction extends Action {
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	@Override
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {
		HttpSession hs = request.getSession();
		
		// DisplayTag Turn a page
		if(hs.getAttribute(TeaConstants.PS_MYALL)!=null){
			return mapping.findForward("suc");
		}
		
		
		
		
		Session s = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try{
			tx=s.beginTransaction();
			TeacherInfo tea = (TeacherInfo) hs.getAttribute(MisConstants.TEACHERINFO_KEY);
			String teaId = tea.getTeacherId();

			if(tea.getConsultTag()){
				java.sql.Date d=new java.sql.Date(new java.util.Date().getTime());
				int year=d.getYear()+1900;
				List temp = s.createQuery("select s.subjectId,s.subject from SubjectInfo as s where s.difficulty=:diff and s.fieldName=:field and s.years=:year")
									.setString("diff","A")
									.setString("field", tea.getFieldName())
									.setInteger("year", year)
									.list();
				List list = new ArrayList();
				Map m=new HashMap();
				for(int i = 0; i<temp.size();i++){
					m=new HashMap();
					Object[] object = (Object[]) temp.get(i);
					m.put("subjectId",object[0]);
					m.put("subject",object[1]);
					
					LevelAId levelAID=new LevelAId();
					levelAID.setSubjectId(Integer.parseInt(object[0].toString()));
					levelAID.setTeacherId(teaId);
					
					LevelA lev = (LevelA)s.get(LevelA.class,levelAID);
					StringBuffer psStatus =new StringBuffer("&nbsp;&nbsp;");
					if(lev!=null){
						psStatus.append(lev.getGrade());
						psStatus.append("--<a href=\"/tea/psGet.do?subId="+object[0]+"\">修改</a>");
					}else{
						psStatus.append("<a href=\"/tea/psGet.do?subId="+object[0]+"\">评审</a>");
					}
					m.put("psStatus",psStatus);
					list.add(m);
				}
				hs.removeAttribute(TeaConstants.PS_MYALL);
				hs.setAttribute(TeaConstants.PS_MYALL,list);
				ActionMessages message = new ActionMessages();
				ActionMessage msg = new ActionMessage("message.psTip",tea.getTeacherName(),tea.getFieldName());
				message.add(ActionMessages.GLOBAL_MESSAGE, msg);
				this.saveMessages(request, message);
			}else{
				ActionErrors errors=new ActionErrors();
				errors.add("notPS",new ActionError("error.notPS"));
		        this.saveErrors(request,errors);
		        saveToken(request);
		        return mapping.getInputForward();
			}
		}catch(Exception e){
			if(tx!=null){ tx.rollback(); }
			e.printStackTrace();
			return mapping.findForward("failure");
		}finally{
			s.close();
		}
		return mapping.findForward("suc");
	}

}

