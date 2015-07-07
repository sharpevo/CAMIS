//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.form;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-20-2007
 * 
 * XDoclet definition:
 * @struts.form name="sendMailForm"
 */
public class SendMailForm extends ValidatorForm {

	// --------------------------------------------------------- Instance Variables
	/** to property */
	private String email;

	/** content property */
	private String content;

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
		ActionErrors errors=super.validate(mapping,request);
		return errors;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.content=null;
		this.email=null;
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the to.
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/** 
	 * Set the to.
	 * @param to The to to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** 
	 * Returns the content.
	 * @return String
	 */
	public String getContent() {
		return content;
	}

	/** 
	 * Set the content.
	 * @param content The content to set
	 * @throws UnsupportedEncodingException 
	 */
	public void setContent(String content){
		this.content = content;
	}

}

