package org.chd.entity;

import java.io.Serializable;

/**
 * @hibernate.class table="Student"
 * @author Administrator
 */
public class StudentInfo implements Serializable {
	public StudentInfo(String studentId, String majorName,
		   String studentPassword, String studentName,
			String studentSex, String studentPhone, String studentEmail) {
		super();
		this.studentId = studentId;
		this.majorName = majorName;
		this.studentPassword = studentPassword;
		this.studentName = studentName;
		this.studentSex = studentSex;
		this.studentPhone = studentPhone;
		this.studentEmail = studentEmail;
	}

	public StudentInfo() {
	}

	private String studentId;

	private String studentClass;


	private String majorName;


	private String studentPassword;

	private String studentName;

	private String studentSex;

	private String studentPhone;

	private String studentEmail;

	/**
	 * @hibernate.id column="StudentId" generator-class="assigned" length="10"
	 */
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/**
	 * @hibernate.property column="MajorName" length="20"
	 */
	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	/**
	 * @hibernate.property column="StudentEmail" length="30"
	 */
	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	/**
	 * @hibernate.property column="StudentName" length="20"
	 */
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @hibernate.property column="StudentPassword" length="10"
	 */
	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	/**
	 * @hibernate.property column="StudentPhone" length="20"
	 */
	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	/**
	 * @hibernate.property column="StudentSex" length="2"
	 */
	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}


	/**
	 * @hibernate.property column="StudentClass" length="10"
	 */
	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}


}
