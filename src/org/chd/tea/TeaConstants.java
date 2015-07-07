package org.chd.tea;

public final class TeaConstants {


	
	/*
	 * Top Level Constants--u should not remove them at any time
	 */
	
	// servletContext variables shared by all the user will be destroyed when restart Tomcat
	public static final String OPTION_FIELD="fieldOption";
	public static final String OPTION_SOURCE="sourceOption";
	public static final String OPTION_TYPE="typeOption";
	public static final String OPTION_PROPERTY="propertyOption";
	public static final String OPTION_TEACHER="teacherOption";
	public static final String OPTION_YEAR="subjectYears";
	
	// to get teacherName by ID faster than from database
	public static final String TEACHER_NAME_ID_MAP="teacherNameIdMap";
	
	
	/*
	 * User Level Constants--removed only when logout
	 */
	
	// state of the user
	public static final String CRUMBS_KEY="crumbs";
	public static final String CRUMBKEY="key";
	public static final String CRUMBLINK="link";
	

	
	/*
	 * ******************************************************************
	 * All of the following variables should be removed at TeaEntryAciton
	 * ******************************************************************
	 */
	
	
	/*
	 * Entity Information
	 */
	
	// for relevent Action and JSP
	public static final String STU_INFO="studentInfo";
	public static final String STU_ID="studentId";
	public static final String STU_NAME="studentName";
	public static final String SUB_ID="subId"; // to fill the ID of Requirement
	public static final String SUB_NAME="subName";
	public static final String SUB_INFO="subjectInfo";
	// " showMySub.jsp & showAllSub.jsp "
	public static final String SUB_INFO_LIST="subjectInfoList";
	// " showMySub.jsp "
	public static final String REQ_IS_VALID = "ReqIsValid";
	// " reviewREQ.jsp "
	public static final String REQ_INFO="requirementInfo";
	//" skimTea.jsp "
	public static final String TEA_INFO="teacherInfo";
	// " showMySub.jsp & showAllSub.jsp "
	public static final String CURRENT_LIST_OBJECT="DisplayTagPaginationObject";
	public static final String TEACHER_ID="teaId"; 
	

	
	/*
	 * Usecases field variables
	 */
	// " zdPre.jsp "
	public static final String ZD_MYALL="ZDList"; // show all the OR of the teacher
	// " psPre.jsp "
	public static final String PS_MYALL="pslist";	
	// " reportList.jsp "
	public static final String CS_MYALL="reportList"; // show all the OR of the teacher
	// " reportList.jsp "
	public static final String REPORT_IS_VALID="reportIsValid";
	// " reportDetail.jsp "
	public static final String CS_REPORT_DETAIL="reportDetail";
	

	

	

	
}
