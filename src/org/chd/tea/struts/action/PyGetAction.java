//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.chd.entity.*;
import org.chd.tea.TeaConstants;
import org.chd.tea.struts.form.StuIdForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import org.chd.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
/** 
 * MyEclipse Struts
 * Creation date: 12-16-2006
 * 
 * XDoclet definition:
 * @struts.action path="/pyGet" name="pyGetForm" input="/pyPre.jsp" scope="request" validate="true"
 * @struts.action-forward name="suc" path="/pypyu.jsp" redirect="true"
 */
public class PyGetAction extends Action {
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
		
		if(isTokenValid(request,true)){
			StuIdForm sf = (StuIdForm) form;
			Session s = HibernateSessionFactory.getSession();
			Transaction tx =null;
			HttpSession hs = request.getSession();
			
			try{
				tx =s.beginTransaction();
				String stuId = sf.getStudentId();
				List list = (List)s.createQuery("from SubjectInfo as s where s.studentId=:id")
												.setString("id",stuId)
												.list();
				StudentInfo stu = (StudentInfo)s.get(StudentInfo.class,new String(stuId));
				if(list.isEmpty() || stu==null){
					ActionMessages message = new ActionMessages();
					ActionMessage msg = new ActionMessage("message.noRecord",stuId);
					message.add("noRecord",msg);
					this.saveMessages(request,message);
			        saveToken(request);
			        return mapping.getInputForward();
				}
				SubjectInfo sub = (SubjectInfo)list.get(0);
				hs.setAttribute(TeaConstants.STU_INFO,stu);
				System.out.println(stu.getStudentName());
				hs.setAttribute(TeaConstants.SUB_ID,sub.getSubjectId());
				hs.setAttribute(TeaConstants.SUB_NAME,sub.getSubject());
				hs.setAttribute(TeaConstants.SUB_INFO,sub.getIntroduction());
				TablePY tpy=(TablePY)s.get(TablePY.class,new Integer(sub.getSubjectId()));
				if(tpy!=null){
					tx.commit();
					return mapping.findForward("beScored");
				}
				saveToken(request);
				tx.commit();
			}catch(Exception e){
				if(tx!=null){ tx.rollback(); }
				e.printStackTrace();
				return mapping.findForward("failure");
			}finally{
				s.close();
			}
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

