package org.chd.entity;

import java.io.Serializable;

/**
 * @hibernate.class table="Subject"
 */

public class SubjectInfo implements Serializable {



	public SubjectInfo() {
	}
    
	
	private Integer subjectId;

	private String typeName;

	private String sourceName;

	private String propertyName;

	private String fieldName;

	private String studentId;

	private String subject;

	private String difficulty;

	private Boolean excellentTag;

	private String teacherAId;

	private String teacherBId;

	private String teacherAPost;

	private String teacherBPost;

	private Integer years;
	
	private Float markPY;
	
	private Float markZD;
	
	private Float markDB;
	
	private Float mark;
	
	private String markGrade;
	
	private String majorName;
	
	private String introduction;
	
	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * @hibernate.id
	 * column="SubjectId"
	 * generator-class="assigned"
	 */
	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
/**
 * @hibernate.property
 * column="Difficulty"
 * length="1"
 */
	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
/**
 * @hibernate.property
 * column="ExternalTag"
 */
	public Boolean getExcellentTag() {
		return excellentTag;
	}

	public void setExcellentTag(Boolean excellentTag) {
		this.excellentTag = excellentTag;
	}
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @hibernate.property
	 * column="StudentId"
	 * length="10"
	 */
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	/**
	 * @hibernate.property
	 * column="Subject"
	 * length="100"
	 */
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getTeacherAId() {
		return teacherAId;
	}

	public void setTeacherAId(String teacherAId) {
		this.teacherAId = teacherAId;
	}
	/**
	 * @hibernate.property
	 * column="TeacherAPost"
	 * length="10"
	 */
	public String getTeacherAPost() {
		return teacherAPost;
	}

	public void setTeacherAPost(String teacherAPost) {
		this.teacherAPost = teacherAPost;
	}

	public String getTeacherBId() {
		return teacherBId;
	}

	public void setTeacherBId(String teacherBId) {
		this.teacherBId = teacherBId;
	}
	/**
	 * @hibernate.property
	 * column="TeacherBPost"
	 * length="10"
	 */
	public String getTeacherBPost() {
		return teacherBPost;
	}

	public void setTeacherBPost(String teacherBPost) {
		this.teacherBPost = teacherBPost;
	}
	/**
	 * @hibernate.property
	 * column="Years"
	 */
	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public Float getMark() {
		return mark;
	}

	public void setMark(Float mark) {
		this.mark = mark;
	}

	public Float getMarkDB() {
		return markDB;
	}

	public void setMarkDB(Float markDB) {
		this.markDB = markDB;
	}

	public String getMarkGrade() {
		return markGrade;
	}

	public void setMarkGrade(String markGrade) {
		this.markGrade = markGrade;
	}

	public Float getMarkPY() {
		return markPY;
	}

	public void setMarkPY(Float markPY) {
		this.markPY = markPY;
	}

	public Float getMarkZD() {
		return markZD;
	}

	public void setMarkZD(Float markZD) {
		this.markZD = markZD;
	}

	public SubjectInfo(String typeName, String sourceName, String propertyName, String fieldName, String subject, String difficulty, String teacherAId, String majorName) {
		super();
		this.typeName = typeName;
		this.sourceName = sourceName;
		this.propertyName = propertyName;
		this.fieldName = fieldName;
		this.subject = subject;
		this.difficulty = difficulty;
		this.teacherAId = teacherAId;
		this.majorName = majorName;
	}

}
