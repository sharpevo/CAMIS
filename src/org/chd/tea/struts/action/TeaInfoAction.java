//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.chd.tea.TeaActionMapping;
import org.chd.tea.TeaConstants;

import fr.improve.struts.taglib.layout.crumb.CrumbImpl;
import org.apache.log4j.Logger;
/** 
 * MyEclipse Struts
 * Creation date: 04-12-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class TeaInfoAction extends Action {

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
		return mapping.findForward("suc");
	}
}
	




