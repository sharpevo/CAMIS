/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package org.chd.struts.stu.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/** 
 * MyEclipse Struts
 * Creation date: 10-20-2006
 * 
 * XDoclet definition:
 * @struts.form name="StuPaperUploadForm"
 */
public class StuPaperUploadForm extends ActionForm {
	
	
	private FormFile stuPaper;
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
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	public FormFile getStuPaper() {
		return stuPaper;
	}

	public void setStuPaper(FormFile stuPaper) {
		this.stuPaper = stuPaper;
	}
}