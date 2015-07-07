//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.form;


import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorActionForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-18-2007
 * 
 * XDoclet definition:
 * @struts.form name="teaInfoForm"
 */
public class TeaInfoForm extends ValidatorActionForm {

	// --------------------------------------------------------- Instance Variables


	
	/** teacherPhone property */
	private String teacherPhone;

	/** teacherEmail property */
	private String teacherEmail;

	/** fieldName property */
	private String fieldName;
	
	/** original property */ 
	private String teacherPassword;

	/** confirm property */ 
	private String confirmPSW;

	/** new property */ 
	private String newPSW;
	
	
	// --------------------------------------------------------- Methods

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {
		ActionErrors errors = super.validate(mapping,request);
		return errors;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.confirmPSW=null;
		this.fieldName=null;
		this.newPSW=null;
		this.teacherPassword=null;
		this.teacherEmail=null;
		this.teacherPhone=null;

		// TODO Auto-generated method stub
	}

	public String getConfirmPSW() {
		return confirmPSW;
	}

	public void setConfirmPSW(String confirmPSW) {
		this.confirmPSW = confirmPSW;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName =fieldName;
	}

	public String getNewPSW() {
		return newPSW;
	}

	public void setNewPSW(String newPSW) {
		this.newPSW = newPSW;
	}

	public String getTeacherPassword() {
		return teacherPassword;
	}

	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public String getTeacherPhone() {
		return teacherPhone;
	}

	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}

}

