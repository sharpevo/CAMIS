/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package org.chd.struts.adm.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/** 
 * MyEclipse Struts
 * Creation date: 10-02-2006
 * 
 * XDoclet definition:
 * @struts.form name="JwyInfoModifyForm"
 */
public class JwyInfoModifyForm extends ValidatorForm {
	/*
	 * Generated fields
	 */

	/** adminId property */
	private String adminId;

	/** adminPassowrd property */
	private String adminPassowrd;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors=super.validate(mapping, request);
		return errors;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.adminId=null;
		this.adminPassowrd=null;
	}

	/** 
	 * Returns the adminId.
	 * @return String
	 */
	public String getAdminId() {
		return adminId;
	}

	/** 
	 * Set the adminId.
	 * @param adminId The adminId to set
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	/** 
	 * Returns the adminPassowrd.
	 * @return String
	 */
	public String getAdminPassowrd() {
		return adminPassowrd;
	}

	/** 
	 * Set the adminPassowrd.
	 * @param adminPassowrd The adminPassowrd to set
	 */
	public void setAdminPassowrd(String adminPassowrd) {
		this.adminPassowrd = adminPassowrd;
	}
}