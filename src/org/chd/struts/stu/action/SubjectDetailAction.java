/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package org.chd.struts.stu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.chd.HibernateSessionFactory;
import org.chd.entity.SubjectInfo;
import org.chd.struts.stu.form.SubjectDetailForm;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** 
 * MyEclipse Struts
 * Creation date: 10-26-2006
 * 
 * XDoclet definition:
 * @struts.action path="/stu/ShowSubjectDetail" name="SubjectDetailForm" scope="request" validate="true"
 * @struts.action-forward name="success" path="/stu/stu_main.jsp" redirect="true"
 */
public class SubjectDetailAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SubjectDetailForm SubjectDetailForm = (SubjectDetailForm) form;
		String temp = SubjectDetailForm.getSubjectId();
		Integer subjectId=Integer.parseInt(temp);
		String pageforward = null;
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			SubjectInfo subject=(SubjectInfo)session.get(SubjectInfo.class,subjectId);
			if(subject==null)
				{
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"errors.TeacherIdError"));
				saveErrors(request,errors);
				pageforward="failure";
				}
			else
			{
			request.setAttribute("subjectdetail",subject);
			pageforward="success";
			}
			tx.commit();
		}catch(Exception e)
		{
			if (tx != null)
				tx.rollback();
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.sqlError"));
			saveErrors(request,errors);
			pageforward="failure";
		}finally
		{
			session.close();
		}
		return mapping.findForward(pageforward);
	}
}