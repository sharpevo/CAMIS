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
 * Creation date: 10-14-2006
 * 
 * XDoclet definition:
 * @struts.form name="AdmInfoModifyForm"
 */
public class AdmInfoModifyForm extends ValidatorForm {
	/*
	 * Generated fields
	 */

	/** confirmPassword property */
	private String confirmPassword;

	/** oldPassword property */
	private String oldPassword;

	/** newPassword property */
	private String newPassword;

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
		this.confirmPassword=null;
		this.newPassword=null;
		this.oldPassword=null;
	}

	/** 
	 * Returns the confirmPassword.
	 * @return String
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/** 
	 * Set the confirmPassword.
	 * @param confirmPassword The confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/** 
	 * Returns the oldPassword.
	 * @return String
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/** 
	 * Set the oldPassword.
	 * @param oldPassword The oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/** 
	 * Returns the newPassword.
	 * @return String
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/** 
	 * Set the newPassword.
	 * @param newPassword The newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}