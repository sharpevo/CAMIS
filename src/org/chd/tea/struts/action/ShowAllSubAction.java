//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import org.chd.HibernateSessionFactory;
import org.chd.entity.SubjectInfo;

import org.chd.tea.HibernatePagination;
import org.chd.tea.TeaConstants;
import org.chd.tea.struts.ShowAllSubPagination;
import org.chd.tea.struts.form.SkimPreForm;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl;

/** 
 * MyEclipse Struts
 * Creation date: 04-23-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class ShowAllSubAction extends Action {
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

		HttpSession hs = request.getSession();
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		String forward = "suc";
		try{
			tx=session.beginTransaction();
			SkimPreForm skimPreForm = (SkimPreForm)form;
			SubjectInfo exampleSub = new SubjectInfo();
			PropertyUtils.copyProperties(exampleSub,skimPreForm);
			if(skimPreForm.getSubYears()!=null&&!skimPreForm.getSubYears().equals("")){
				exampleSub.setYears(Integer.parseInt(skimPreForm.getSubYears()));
			}
			
			//BeanUtils.copyProperties(exampleSub,skimPreForm);
			
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SubjectInfo.class)
																.add(Example.create(exampleSub));
			ShowAllSubPagination pagelist = (ShowAllSubPagination) hs.getAttribute(TeaConstants.CURRENT_LIST_OBJECT);
			if(pagelist==null || request.getParameter("submit") != null){
				Map map = (Map) this.getServlet().getServletContext().getAttribute(TeaConstants.TEACHER_NAME_ID_MAP);
				pagelist = new ShowAllSubPagination(10,detachedCriteria,session,map);
				forward = "forward";
			}
			hs.removeAttribute(TeaConstants.CURRENT_LIST_OBJECT);
			hs.setAttribute(TeaConstants.CURRENT_LIST_OBJECT, pagelist);
			List resultList = pagelist.getList(request,session);
			hs.removeAttribute(TeaConstants.SUB_INFO_LIST);
			hs.setAttribute(TeaConstants.SUB_INFO_LIST,resultList);
        }catch(Exception e){
        	if(tx!=null){ tx.rollback(); }
        	e.printStackTrace();
        	return mapping.findForward("failure");
        }finally{
        	session.close();
        }
		return mapping.findForward(forward);
	}
		

}

