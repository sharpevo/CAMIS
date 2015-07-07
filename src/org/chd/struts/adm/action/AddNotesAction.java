/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package org.chd.struts.adm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.chd.HibernateSessionFactory;
import org.chd.entity.News;
import org.chd.struts.adm.form.AddNotesForm;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * MyEclipse Struts Creation date: 10-03-2006
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/AddNotes" name="AddNotesForm" input="/news_publish.jsp"
 *                scope="request" validate="true"
 * @struts.action-forward name="success" path="/news_publish.jsp"
 *                        redirect="true"
 */
public class AddNotesAction extends Action {
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
		AddNotesForm AddNotesForm = (AddNotesForm) form;	
		java.sql.Date addDate=new java.sql.Date(new java.util.Date().getTime());	
		String pageforward = "";
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			String news=new String(AddNotesForm.getNews().getBytes("ISO-8859-1"),"GBK");	
			String newsName=new String(AddNotesForm.getNewsName().getBytes("ISO-8859-1"),"GBK");
			String majorName=new String(AddNotesForm.getMajorName().getBytes("ISO-8859-1"),"GBK");
			tx = session.beginTransaction();
			News newsInfo=new News();
			newsInfo.setNews(news);
			newsInfo.setMajorName(majorName);
			newsInfo.setNewsName(newsName);
			newsInfo.setAddDate(addDate);
			session.save(newsInfo);
			tx.commit();
			pageforward = "success";
		} catch (Exception e) {
			if (tx != null)
				e.printStackTrace();
				tx.rollback();
			ActionErrors actionErrors = new ActionErrors();
			actionErrors.add(ActionErrors.GLOBAL_ERROR, new ActionError(
					"errors.SQLError"));
			ActionForward returnActionForward = new ActionForward(mapping
					.getInput());
			return returnActionForward;
		} finally {
			session.close();
		}
		ActionForward returnActionForward = mapping.findForward(pageforward);
		return returnActionForward;
	}
}