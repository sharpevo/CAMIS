/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package org.chd.struts.stu.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/** 
 * MyEclipse Struts
 * Creation date: 10-20-2006
 * 
 * XDoclet definition:
 * @struts.form name="StuPswModForm"
 */
public class StuPswModForm extends ValidatorForm {
	/*
	 * Generated fields
	 */

	
	/** confirmPsw property */
	private String confirmPsw;

	/** newPsw property */
	private String newPsw;

	/** oldPsw property */
	private String oldPsw;

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
		this.newPsw=null;
		this.oldPsw=null;
		this.confirmPsw=null;
	}

	/** 
	 * Returns the confirmPsw.
	 * @return String
	 */
	public String getConfirmPsw() {
		return confirmPsw;
	}

	/** 
	 * Set the confirmPsw.
	 * @param confirmPsw The confirmPsw to set
	 */
	public void setConfirmPsw(String confirmPsw) {
		this.confirmPsw = confirmPsw;
	}

	/** 
	 * Returns the newPsw.
	 * @return String
	 */
	public String getNewPsw() {
		return newPsw;
	}

	/** 
	 * Set the newPsw.
	 * @param newPsw The newPsw to set
	 */
	public void setNewPsw(String newPsw) {
		this.newPsw = newPsw;
	}

	/** 
	 * Returns the oldPsw.
	 * @return String
	 */
	public String getOldPsw() {
		return oldPsw;
	}

	/** 
	 * Set the oldPsw.
	 * @param oldPsw The oldPsw to set
	 */
	public void setOldPsw(String oldPsw) {
		this.oldPsw = oldPsw;
	}

}