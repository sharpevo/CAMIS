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
 * Creation date: 10-18-2006
 * 
 * XDoclet definition:
 * @struts.form name="StuInfoModForm"
 */
public class StuInfoModForm extends ValidatorForm {
	/*
	 * Generated fields
	 */

	/** studetnEmail property */
	private String studentEmail;

	/** studentId property */
	private String studentId;

	/** studentPhone property */
	private String studentPhone;

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
		this.studentEmail=null;
		this.studentId=null;
		this.studentPhone=null;
	}

	/** 
	 * Returns the studetnEmail.
	 * @return String
	 */
	public String getStudentEmail() {
		return studentEmail;
	}

	/** 
	 * Set the studetnEmail.
	 * @param studetnEmail The studetnEmail to set
	 */
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	/** 
	 * Returns the studentId.
	 * @return String
	 */
	public String getStudentId() {
		return studentId;
	}

	/** 
	 * Set the studentId.
	 * @param studentId The studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/** 
	 * Returns the studentPhone.
	 * @return String
	 */
	public String getStudentPhone() {
		return studentPhone;
	}

	/** 
	 * Set the studentPhone.
	 * @param studentPhone The studentPhone to set
	 */
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
}