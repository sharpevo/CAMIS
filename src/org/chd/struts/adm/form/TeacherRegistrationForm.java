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
 * Creation date: 09-25-2006
 * 
 * XDoclet definition:
 * @struts.form name="TeacherRegistrationForm"
 */
public class TeacherRegistrationForm extends ValidatorForm {
	/*
	 * Generated fields
	 */

	/** teacherName property */
	private String teacherName;

	/** teacherPassword property */
	private String teacherPassword;

	/** majorName property */
	private String majorName;

	/** fieldName property */
	private String fieldName;

	/** teacherSex property */
	private String teacherSex;

	/** teacherId property */
	private String teacherId;

	private String post;
	
	private String teacherPhone;
	
	private String teacherEmail;
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
		this.fieldName=null;
		this.majorName=null;
		this.post=null;
		this.teacherEmail=null;
		this.teacherId=null;
		this.teacherName=null;
		this.teacherPassword=null;
		this.teacherPhone=null;
		this.teacherSex=null;
	}

	/** 
	 * Returns the teacherName.
	 * @return String
	 */
	public String getTeacherName() {
		return teacherName;
	}

	/** 
	 * Set the teacherName.
	 * @param teacherName The teacherName to set
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	/** 
	 * Returns the teacherPassword.
	 * @return String
	 */
	public String getTeacherPassword() {
		return teacherPassword;
	}

	/** 
	 * Set the teacherPassword.
	 * @param teacherPassword The teacherPassword to set
	 */
	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}

	/** 
	 * Returns the majorName.
	 * @return String
	 */
	public String getMajorName() {
		return majorName;
	}

	/** 
	 * Set the majorName.
	 * @param majorName The majorName to set
	 */
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	/** 
	 * Returns the fieldName.
	 * @return String
	 */
	public String getFieldName() {
		return fieldName;
	}

	/** 
	 * Set the fieldName.
	 * @param fieldName The fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/** 
	 * Returns the teacherSex.
	 * @return String
	 */
	public String getTeacherSex() {
		return teacherSex;
	}

	/** 
	 * Set the teacherSex.
	 * @param teacherSex The teacherSex to set
	 */
	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}

	/** 
	 * Returns the teacherId.
	 * @return String
	 */
	public String getTeacherId() {
		return teacherId;
	}

	/** 
	 * Set the teacherId.
	 * @param teacherId The teacherId to set
	 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
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