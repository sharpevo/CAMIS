//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.chd.HibernateSessionFactory;
import org.chd.entity.Requirement;
import org.chd.tea.TeaConstants;
import org.chd.tea.struts.form.RequirementForm;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** 
 * MyEclipse Struts
 * Creation date: 04-21-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class RequirementInfoAction extends DispatchAction {

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
	@SuppressWarnings("deprecation")
	public ActionForward saveOrUpdate(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		
		HttpSession hs = request.getSession();
		// " showMySub.jsp "
		hs.removeAttribute(TeaConstants.CURRENT_LIST_OBJECT);
		hs.removeAttribute(TeaConstants.REQ_IS_VALID);
		Session s = HibernateSessionFactory.getSession();
		Transaction tx = null;		
		
		if (isCancelled(request)) {
			resetToken(request);
			return mapping.findForward("cancel");
		}
		
		if(isTokenValid(request,true)){
			try{
				tx = s.beginTransaction();	
				RequirementForm reqForm = (RequirementForm) form;
				String str_subId = hs.getAttribute(TeaConstants.SUB_ID).toString();

				int subId = Integer.parseInt(str_subId);
		        java.sql.Date date = new java.sql.Date((new java.util.Date()).getTime());
				Requirement req = (Requirement)s.get(Requirement.class,new Integer(subId));
				if(req==null){
					System.out.println("no req");
					req = new Requirement();
				}else{
					System.out.println("has req");
				}
			        PropertyUtils.copyProperties(req,reqForm.getRequirement());
			        req.setAddDate(date);
			        req.setSubjectId(subId);
		        hs.removeAttribute(TeaConstants.REQ_INFO);
				request.setAttribute(TeaConstants.REQ_INFO,req);
				
				s.saveOrUpdate(req);
				tx.commit();
				resetToken(request);
			}catch(Exception e){
				if(tx!=null){ tx.rollback(); }
				e.printStackTrace();
				return mapping.findForward("failure");
			}
			return mapping.findForward("suc");
		}else{
			ActionErrors errors=new ActionErrors();
			errors.add("submitagain",new ActionError("error.submitagain"));
        	this.saveErrors(request,errors);
        	saveToken(request);
        	return mapping.getInputForward();
		}
	
	}
	
	public ActionForward delete(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)throws Exception {

		HttpSession hs = request.getSession();
		// " showMySub.jsp "
		hs.removeAttribute(TeaConstants.CURRENT_LIST_OBJECT);
		Session s = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			
			int id =Integer.parseInt(request.getParameter("subId"));   
			Requirement req = (Requirement) s.get(Requirement.class,new Integer(id));
			s.delete(req);
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

