package org.chd.entity;

import java.io.Serializable;


/**
 * @hibernate.class table="teacher"
 * @author Administrator
 * 
 */
public class TeacherInfo implements Serializable {
	

	public TeacherInfo(String teacherId, String teacherPassword, String teacherName, String teacherSex, String post, String majorName, String fieldName, Float workLoad, Boolean consultTag, Integer groupNo, String roleName) {
		super();
		this.teacherId = teacherId;
		this.teacherPassword = teacherPassword;
		this.teacherName = teacherName;
		this.teacherSex = teacherSex;
		this.post = post;
		this.majorName = majorName;
		this.fieldName = fieldName;
		this.workload = workLoad;
		this.consultTag = consultTag;
		this.groupNo = groupNo;
		this.roleName = roleName;
	}

	public TeacherInfo() {
	}

	private String teacherId;

	private String teacherPassword;

	private String teacherName;

	private String teacherSex;

	private String post;

	private String majorName;

	private String fieldName;

	private Float workload; 
	
	private String teacherEmail;
	
	private String teacherPhone;

	private Boolean consultTag;
	
	private Integer groupNo;
	
	private String roleName;

	public Integer getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(Integer groupNo) {
		this.groupNo = groupNo;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @hibernate.id 
	 * column="TeacherId" 
	 * generator-class="assigned"
	 * length="10"
	 */
	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	/**
	 * @hibernate.property column="ConsultTag"
	 */
	public Boolean getConsultTag() {
		return consultTag;
	}

	public void setConsultTag(Boolean consultTag) {
		this.consultTag = consultTag;
	}

	/**
	 * @hibernate.property column="FieldName" length="50"
	 */

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @hibernate.property column="Post" length="10"
	 */

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	/**
	 * @hibernate.property column="TeacherName" length="20"
	 */

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	/**
	 * @hibernate.property column="TeacherPassword" length="10"
	 */

	public String getTeacherPassword() {
		return teacherPassword;
	}

	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}

	/**
	 *@hibernate.property column="TeacherSex" length="2"
	 */

	public String getTeacherSex() {
		return teacherSex;
	}

	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}

	/**
	 *@hibernate.property column="Workload"
	 */

	public Float getWorkload() {
		return workload;
	}

	public void setWorkload(Float workload) {
		this.workload = workload;
	}

	/**
	 *@hibernate.property column="MajorName" length="10"
	 */
	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	/**
	 *@hibernate.property column="TeacherPhone" length="10"
	 */
	public String getTeacherPhone() {
		return teacherPhone;
	}

	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}
	/**
	 *@hibernate.property column="TeacherEmail" length="10"
	 */
	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}
}
