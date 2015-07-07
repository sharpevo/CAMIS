package org.chd.entity;

import java.io.Serializable;
import java.sql.Date;

public class TableDB implements Serializable {

	private Integer subjectId;

	private String teacherId;

	private float achievement;

	private float workLoad;

	private float innovation;

	private float verbalReport;

	private float reply;

	private String comment;

	private Date addDate;

	public TableDB() {
	}

	public TableDB(Integer subjectId, String teacherId, float achievement,
			float workLoad, float innovation, float verbalReport, float reply,
			String tag, String comment, Date date) {
		super();
		this.subjectId = subjectId;
		this.teacherId = teacherId;
		this.achievement = achievement;
		this.workLoad = workLoad;
		this.innovation = innovation;
		this.verbalReport = verbalReport;
		this.reply = reply;
		this.comment = comment;
		this.addDate = date;
	}

	public float getAchievement() {
		return achievement;
	}

	public void setAchievement(float achievement) {
		this.achievement = achievement;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date date) {
		this.addDate = date;
	}

	public float getInnovation() {
		return innovation;
	}

	public void setInnovation(float innovation) {
		this.innovation = innovation;
	}

	public float getReply() {
		return reply;
	}

	public void setReply(float reply) {
		this.reply = reply;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public float getVerbalReport() {
		return verbalReport;
	}

	public void setVerbalReport(float verbalReport) {
		this.verbalReport = verbalReport;
	}

	public float getWorkLoad() {
		return workLoad;
	}

	public void setWorkLoad(float workLoad) {
		this.workLoad = workLoad;
	}

}
