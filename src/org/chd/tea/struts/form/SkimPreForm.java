//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package org.chd.tea.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 12-19-2006
 * 
 * XDoclet definition:
 * @struts.form name="skimPreForm"
 */
public class SkimPreForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables

	private boolean flag; 
	
	private String difficulty;
	private String fieldName;
	private String teacherAId;
	private String subyears;
	
	/** pageNum property */
	private String pageNum;

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

		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.difficulty=null;
		this.fieldName=null;
		this.teacherAId=null;
		this.flag = false;
		this.pageNum = null;
		/*java.sql.Date d=new java.sql.Date(new java.util.Date().getTime());
		int year=d.getYear()+1900;
		this.years=String.valueOf(year);*/
		this.subyears=null;
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the pageNum.
	 * @return Integer
	 */
	public String getPageNum() {
		return pageNum;
	}

	/** 
	 * Set the pageNum.
	 * @param pageNum The pageNum to set
	 */
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String diff) {
		if(diff.equals("")){
			diff = null;
		}
		this.difficulty = diff;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String field){
		if(field.equals("")){
			field = null;
		}
		this.fieldName =field;
	}

	public String getTeacherAId() {
		return teacherAId;
	}

	public void setTeacherAId(String teacher){
		if(teacher.equals("")){
			teacher = null;
		}
		this.teacherAId =teacher;
	}

	public String getSubYears() {
		return subyears;
	}

	public void setSubYears(String years) {
		if(years.equals("")){
			this.subyears=null;
		}
		this.subyears = years;
	}

}

