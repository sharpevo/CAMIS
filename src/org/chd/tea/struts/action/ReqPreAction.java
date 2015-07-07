//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.chd.tea.TeaConstants;
import org.chd.tea.struts.form.RequirementForm;
import org.chd.HibernateSessionFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.commons.beanutils.PropertyUtils;
import org.chd.entity.Requirement;
import org.chd.entity.SubjectInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** 
 * MyEclipse Struts
 * Creation date: 04-11-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class ReqPreAction extends Action {

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
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response){
		
		Session s = HibernateSessionFactory.getSession();
		HttpSession hs = request.getSession();
		
		// " showMySub.jsp "
		hs.removeAttribute(TeaConstants.SUB_INFO_LIST);
		Transaction tx=null;

		try{
			tx=s.beginTransaction();
			String str_subId = request.getParameter(TeaConstants.SUB_ID);
			
			// processing requirment need a Id 
			if(str_subId==null){
				saveToken(request);
				return mapping.findForward("failure");
			}
			int subId = Integer.parseInt(str_subId);
			hs.setAttribute(TeaConstants.SUB_ID,subId);
			Requirement req = (Requirement)s.get(Requirement.class,new Integer(subId));
			
			SubjectInfo sub = (SubjectInfo)s.get(SubjectInfo.class,new Integer(subId));
			hs.setAttribute(TeaConstants.SUB_NAME,sub.getSubject());
			
			//does the request come form a Modify Actions?  
			if(req==null){
				req = new Requirement();
				saveToken(request);
				return mapping.findForward("suc");
			}
			hs.setAttribute(TeaConstants.REQ_IS_VALID, "true");
			
			form = new RequirementForm();
			RequirementForm requirementForm = (RequirementForm) form;
			requirementForm.setRequirement(req);
			request.setAttribute(mapping.getAttribute(),form);
			saveToken(request);
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

