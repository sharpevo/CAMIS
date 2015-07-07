//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.chd.entity.TeacherInfo;
import org.chd.tea.TeaConstants;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;
import org.chd.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.chd.MisConstants;
/** 
 * MyEclipse Struts
 * Creation date: 04-21-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class TeaEntryAction extends Action {

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

		
		
		HttpSession hs = request.getSession();
		
		hs.removeAttribute(TeaConstants.CS_MYALL);
		hs.removeAttribute(TeaConstants.CS_REPORT_DETAIL);
		hs.removeAttribute(TeaConstants.PS_MYALL);
		hs.removeAttribute(TeaConstants.REPORT_IS_VALID);
		hs.removeAttribute(TeaConstants.REQ_INFO);
		hs.removeAttribute(TeaConstants.REQ_IS_VALID);
		hs.removeAttribute(TeaConstants.STU_ID);
		hs.removeAttribute(TeaConstants.STU_INFO);
		hs.removeAttribute(TeaConstants.STU_NAME);
		hs.removeAttribute(TeaConstants.SUB_ID);
		hs.removeAttribute(TeaConstants.SUB_INFO);
		hs.removeAttribute(TeaConstants.SUB_INFO_LIST);
		hs.removeAttribute(TeaConstants.SUB_NAME);
		hs.removeAttribute(TeaConstants.TEA_INFO);
		hs.removeAttribute(TeaConstants.ZD_MYALL);
		hs.removeAttribute(TeaConstants.CURRENT_LIST_OBJECT);
		/*
		 * For testing
		 * 
		// simulator Login
		Session s = HibernateSessionFactory.getSession();
		if(hs.getAttribute(MisConstants.TEACHERINFO_KEY)!=null){
			return mapping.findForward("suc");
		}else{
			String teaId = "0004";
			TeacherInfo tea = (TeacherInfo)s.get(TeacherInfo.class,new String(teaId) );
			hs.setAttribute(MisConstants.TEACHERINFO_KEY, tea);
			Map crumb = new HashMap();
			crumb.put(TeaConstants.CRUMBKEY, "action.teaEntry");
			crumb.put(TeaConstants.CRUMBKEY, "action.showAllSub");
			List crumbs = new ArrayList();
			crumbs.add(crumb);
			hs.setAttribute(TeaConstants.CRUMBS_KEY, crumbs);
			hs.setAttribute("ISLOGINED", "tea");
		}*/
		
		
		if(request.getParameter("forward") != null){
			String forward = request.getParameter("forward");
			if(forward.equals("logout")){
				hs.removeAttribute(TeaConstants.CRUMBS_KEY);
				hs.removeAttribute(TeaConstants.CRUMBLINK);
				hs.removeAttribute(TeaConstants.CRUMBKEY);
			}
			
			return mapping.findForward(forward);
		}
		
		return mapping.findForward("suc");
	}


}

