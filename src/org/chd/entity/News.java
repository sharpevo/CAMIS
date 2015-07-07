package org.chd.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * @hibernate.class table="News"
 * @author Administrator
 * 
 */
public class News implements Serializable {

	private Integer newsId;

	private Date addDate;

	private String newsName;

	private String news;

	private String majorName;

	/**
	 * @hibernate.id column="NewsId" generator-class="assigned"
	 */
	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getNewsName() {
		return newsName;
	}

	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}

	/**
	 * @hibernate.property column="News"
	 */
	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}
}
