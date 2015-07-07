//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.chd.entity.SubjectInfo;
import org.chd.tea.TeaConstants;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.chd.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
/** 
 * MyEclipse Struts
 * Creation date: 12-20-2006
 * 
 * XDoclet definition:
 * @struts.action path="/skimSub" name="skimSubForm" input="/skimSub.jsp" scope="request" validate="true"
 * @struts.action-forward name="suc" path="ss" redirect="true"
 */
public class SkimSubAction extends Action {

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
	@Override
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {

		HttpSession hs = request.getSession();
		Session s = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			String id = request.getParameter("subId");
			int subid = Integer.parseInt(id);
			SubjectInfo sub = (SubjectInfo)s.get(SubjectInfo.class,new Integer(subid));
			request.setAttribute(TeaConstants.SUB_INFO,sub);
			tx.commit();
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

