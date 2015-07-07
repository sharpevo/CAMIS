package org.chd.entity;

import java.io.Serializable;
import java.sql.Date;

public class TableZD implements Serializable {


	public TableZD(Integer subjectId, String teacherId, float workLoad, float argumentation, float translating, float design, float designSpecification, float innovation, Boolean tag, String comment, Date dater) {
		super();
		this.subjectId = subjectId;
		this.teacherId = teacherId;
		this.workLoad = workLoad;
		this.argumentation = argumentation;
		this.translating = translating;
		this.design = design;
		this.designSpecification = designSpecification;
		this.innovation = innovation;
		this.tag = tag;
		this.comment = comment;
		this.addDate = dater;
	}

	public TableZD(){}
	private Integer subjectId;

	private String teacherId;

	private float workLoad;

	private float argumentation;

	private float translating;

	private float design;

	private float designSpecification;

	private float innovation;

	private Boolean tag;

	private String comment;

	private Date addDate;

	public float getArgumentation() {
		return argumentation;
	}

	public void setArgumentation(float argumentation) {
		this.argumentation = argumentation;
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

	public void setAddDate(Date dater) {
		this.addDate = dater;
	}

	public float getDesign() {
		return design;
	}

	public void setDesign(float design) {
		this.design = design;
	}

	public float getDesignSpecification() {
		return designSpecification;
	}

	public void setDesignSpecification(float designSpecification) {
		this.designSpecification = designSpecification;
	}

	public float getInnovation() {
		return innovation;
	}

	public void setInnovation(float innovation) {
		this.innovation = innovation;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Boolean getTag() {
		return tag;
	}

	public void setTag(Boolean tag) {
		this.tag = tag;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public float getTranslating() {
		return translating;
	}

	public void setTranslating(float translating) {
		this.translating = translating;
	}

	public float getWorkLoad() {
		return workLoad;
	}

	public void setWorkLoad(float workLoad) {
		this.workLoad = workLoad;
	}
	

}