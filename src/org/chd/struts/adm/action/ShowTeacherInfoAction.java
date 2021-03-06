/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package org.chd.struts.adm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.chd.HibernateSessionFactory;
import org.chd.MisConstants;
import org.chd.entity.TeacherInfo;
import org.chd.struts.adm.form.ShowTeacherInfoForm;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** 
 * MyEclipse Struts
 * Creation date: 10-09-2006
 * 
 * XDoclet definition:
 * @struts.action path="/ShowTeacherInfo" name="ShowTeacherInfoForm" scope="request" validate="true"
 * @struts.action-forward name="success" path="/tea_info_list.jsp" redirect="true"
 */
public class ShowTeacherInfoAction extends Action {
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
		ShowTeacherInfoForm ShowTeacherInfoForm = (ShowTeacherInfoForm) form;
		String teacherId=ShowTeacherInfoForm.getTeacherId();
		Session session = HibernateSessionFactory.getSession();
		String pageforward=null;
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			TeacherInfo teacher=(TeacherInfo)session.get(TeacherInfo.class,teacherId);
			if(teacher==null)
				{
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"errors.TeacherIdError"));
				saveErrors(request,errors);
				pageforward="failure";
				}
			else
			{
			request.setAttribute(MisConstants.TEACHERINFO_KEY,teacher);
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