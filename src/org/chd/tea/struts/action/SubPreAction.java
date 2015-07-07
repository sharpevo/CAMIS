//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.commons.beanutils.PropertyUtils;
import javax.servlet.http.HttpSession;
import org.chd.HibernateSessionFactory;
import org.chd.entity.SubjectInfo;
import org.chd.tea.TeaConstants;
import org.chd.tea.struts.form.SubjectForm;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** 
 * MyEclipse Struts
 * Creation date: 04-10-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class SubPreAction extends Action {

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
		HttpServletResponse response) {
		
		Session s = HibernateSessionFactory.getSession();
		HttpSession hs = request.getSession();
		
		// " showMySub.jsp "
		hs.removeAttribute(TeaConstants.SUB_INFO_LIST);
		Transaction tx = null;
        try{
			tx = s.beginTransaction();
			
			String str_subId=request.getParameter(TeaConstants.SUB_ID);
			
			//does this request come from Mofify actions? 
			if(str_subId==null){
//				or the new subject will have a Id, the SubjectInfoAction will abvocate that
//				the id of the subject which is before is just the contempory subject, 
//				as a result, SIA will treat with this request as a update rather than save a new one.				
				hs.removeAttribute(TeaConstants.SUB_ID);
				hs.removeAttribute(TeaConstants.SUB_NAME);
				hs.removeAttribute(TeaConstants.REQ_INFO);
				hs.removeAttribute(TeaConstants.REQ_IS_VALID);
				hs.removeAttribute(TeaConstants.SUB_INFO_LIST);
				saveToken(request);
				return mapping.findForward("suc");
			}
			
			int subId = Integer.parseInt(str_subId);
			hs.setAttribute(TeaConstants.SUB_ID,subId);
			SubjectInfo sub = (SubjectInfo)s.get(SubjectInfo.class,new Integer(subId));
			form = new SubjectForm();
			request.setAttribute(mapping.getAttribute(),form);
			PropertyUtils.copyProperties(form,sub);
			request.setAttribute(mapping.getAttribute(),form);
			saveToken(request); // generate a token for fillSUB.jsp
			
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

