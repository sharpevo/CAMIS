package org.chd.entity;

import java.io.Serializable;
import java.sql.Date;

public class OpeningReport implements Serializable {

    private String studentId;
    
    private String content;
    
    private Date addDate;

	
	public OpeningReport(){}


	public Date getAddDate() {
		return addDate;
	}


	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	

}
