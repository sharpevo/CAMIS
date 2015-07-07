//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.chd.MisConstants;
import org.chd.entity.TeacherInfo;

/** 
 * MyEclipse Struts
 * Creation date: 04-21-2007
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class DbPreAction extends Action {

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
		TeacherInfo teacher = (TeacherInfo) hs.getAttribute(MisConstants.TEACHERINFO_KEY);
		if("组长".equals(teacher.getRoleName())
				||"秘书".equals(teacher.getRoleName())){
			saveToken(request);
			return mapping.findForward("suc");
		}else{
        	ActionErrors errors = new ActionErrors();
        	errors.add("errors",new ActionError("error.illegalRole",teacher.getRoleName()));
        	this.saveErrors(request,errors);
			return mapping.findForward("illegalRole");
		}
		
		
	}

}

