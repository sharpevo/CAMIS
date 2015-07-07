//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-10-2007
 * 
 * XDoclet definition:
 * @struts.form name="subjectForm"
 */
public class SubjectForm extends ValidatorForm {

	// --------------------------------------------------------- Instance Variables
	private String subject;
	private String difficulty;
	private String typeName;
	private String fieldName;
	private String sourceName;
	private String propertyName;
	private boolean excellentTag;
	private String introduction;
	
	
	
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
		ActionErrors errors= super.validate(mapping,request);
		return errors;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.difficulty=null;
		this.fieldName=null;
		this.excellentTag=false;
		this.introduction=null;
		this.propertyName=null;
		this.sourceName=null;
		this.subject=null;
		this.typeName=null;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public boolean getExcellentTag() {
		return excellentTag;
	}

	public void setExcellentTag(boolean excellentTag) {
		this.excellentTag = excellentTag;
	}

	public String getFieldName(){
		return fieldName;
	}

	public void setFieldName(String fieldName){
		this.fieldName = fieldName;
	}

	public String getIntroduction(){
		return  introduction;
	}

	public void setIntroduction(String introduction){
		this.introduction =introduction;
	}

	public String getPropertyName(){
		return propertyName;
	}

	public void setPropertyName(String propertyName){
		this.propertyName = propertyName;
	}

	public String getSourceName(){
		return sourceName;
	}

	public void setSourceName(String sourceName){
		this.sourceName = sourceName;
	}

	public String getSubject(){
		return subject;
	}

	public void setSubject(String subject){
		this.subject = subject;
	}

	public String getTypeName(){
		return typeName;
	}

	public void setTypeName(String typeName){
		this.typeName =typeName;
	}



}

