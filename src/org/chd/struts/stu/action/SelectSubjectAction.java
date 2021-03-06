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
import org.chd.HibernateSessionFactory;
import org.chd.MisConstants;
import org.chd.entity.StudentInfo;
import org.chd.entity.SubjectInfo;
import org.chd.struts.stu.form.SelectSubjectForm;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/** 
 * MyEclipse Struts
 * Creation date: 10-26-2006
 * 
 * XDoclet definition:
 * @struts.action path="/stu/SelectSubject" name="SelectSubjectForm" scope="request" validate="true"
 * @struts.action-forward name="success" path="/stu/stu_main.jsp" redirect="true"
 */
public class SelectSubjectAction extends Action {
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
		StudentInfo student=(StudentInfo)request.getSession().getAttribute(MisConstants.STUDENTINFO_KEY);;
		SelectSubjectForm SelectSubjectForm = (SelectSubjectForm) form;
		String studentId=student.getStudentId();
		Integer subjectId=Integer.parseInt(SelectSubjectForm.getSubjectId());	
		String pageforward=null;
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria c2 = session.createCriteria(SubjectInfo.class);
			c2.add(Restrictions.eq("studentId", studentId));
		    if(c2.list().size()>0)
		    {
		    	pageforward="cfxt";
		    }
		    else
		    {
			  SubjectInfo subject=(SubjectInfo)session.get(SubjectInfo.class, subjectId);
			  if(subject.getStudentId()==null||subject.getStudentId().equals(""))
		      {
		      subject.setStudentId(studentId);
		      session.saveOrUpdate(subject);
			  pageforward="success";
			  request.setAttribute(MisConstants.SUBJETINFO_KEY ,subject);
			  tx.commit();
		      }
			  else
			  {
				pageforward="failure";
			  }
		   }
		}catch(Exception e)
		{
			if (tx != null)
				tx.rollback();
			pageforward="false";
		}
		finally{
			session.close();
		}
		return mapping.findForward(pageforward);
	}
}