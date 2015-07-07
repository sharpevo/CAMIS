//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/** 
 * MyEclipse Struts
 * Creation date: 12-20-2006
 * 
 * XDoclet definition:
 * @struts.form name="psForm"
 */
public class PsForm extends ValidatorForm {

	// --------------------------------------------------------- Instance Variables

	/** grade property */
	private String grade;

	// --------------------------------------------------------- Methods

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	@Override
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
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.grade=null;
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the grade.
	 * @return String
	 */
	public String getGrade() {
		return grade;
	}

	/** 
	 * Set the grade.
	 * @param grade The grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

}

