/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package org.chd.struts.stu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.chd.HibernateSessionFactory;
import org.chd.MisConstants;
import org.chd.entity.SubjectInfo;
import org.chd.struts.stu.form.StuSelectSubjectForm;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * MyEclipse Struts Creation date: 10-18-2006
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/stu/StuSelectSubject" name="StuSelectSubjectForm"
 *                scope="request" validate="true"
 * @struts.action-forward name="success" path="/stu/student_select.jsp"
 *                        redirect="true"
 */
public class StuSelectSubjectAction extends Action {
	/*
	 * Generated Methods
	 */

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		StuSelectSubjectForm StuSelectSubjectForm = (StuSelectSubjectForm) form;
		String pageforward = "";
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Integer rscount = (Integer) session
					.createQuery(
							"select count(*) from SubjectInfo s where s.studentId is null or s.studentId=''")
					.uniqueResult();
			int totalpage = 0;
			if (rscount % MisConstants.PAGESIZE != 0)
				{
				totalpage = rscount / MisConstants.PAGESIZE;
				}

			else
				{
				totalpage = rscount.intValue() / (MisConstants.PAGESIZE) + 1;
				}
			if(totalpage<=0) totalpage=1;
			int nowpage = Integer.parseInt(StuSelectSubjectForm.getNowPage());
			if (nowpage <= 0)nowpage = 1;
			if (nowpage > totalpage) nowpage = totalpage;
			int firstResult = (nowpage - 1) * MisConstants.PAGESIZE;
			List subject_list = session.createCriteria(SubjectInfo.class).add(Restrictions.isNull("studentId"))
					.setFirstResult(firstResult).setMaxResults(
							MisConstants.PAGESIZE).list();
			List source_list = session.createQuery("from SourceInfo").list();
			List field_list = session.createQuery("from FieldInfo").list();
			List teacher_list = session.createQuery("from TeacherInfo").list();
			List type_list = session.createQuery("from TypeInfo").list();
			List property_list = session.createQuery("from PropertyInfo")
					.list();
			tx.commit();
			request.setAttribute(MisConstants.FIELDLIST_KEY, field_list);
			request.setAttribute(MisConstants.TEACHERLIST_KEY, teacher_list);
			request.setAttribute(MisConstants.SUBJECTLISTPAGING_KEY, subject_list);
			request.setAttribute(MisConstants.SOURCELIST_KEY, source_list);
			request.setAttribute(MisConstants.PROPERTYLIST_KEY, property_list);
			request.setAttribute(MisConstants.TYPELIST_KEY, type_list);
			request.setAttribute(MisConstants.TOTALPAGE_KEY, totalpage);
			request.setAttribute(MisConstants.NOWPAGE_KEY, nowpage);
			pageforward = "success";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			pageforward = "failure";
		} finally {
			session.close();
		}
		ActionForward ActionForward = mapping.findForward(pageforward);
		return ActionForward;
	}
}