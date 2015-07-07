package org.chd.entity;

import java.io.Serializable;
/**
 * @hibernate.class
 * table="Admin"
 * @author Administrator
 *
 */
public class AdminInfo implements Serializable{
	public AdminInfo(String adminId, String adminPassword, Boolean adminTag) {
		super();
		this.adminId = adminId;
		this.adminPassword = adminPassword;
		this.adminTag = adminTag;
	}
	public AdminInfo(){}
	private String adminId;
	private String adminPassword;
	private Boolean adminTag;
	/**
	 * @hibernate.id
	 * column="AdminId"
	 * generator-class="assigned"
	 */
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	/**
	 * @hibernate.property
	 * column="AdminPassword"
	 * length="10"
	 */
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	/**
	 * @hibernate.property
	 * column="AdminTag"
	 */
	public Boolean getAdminTag() {
		return adminTag;
	}

	public void setAdminTag(Boolean adminTag) {
		this.adminTag = adminTag;
	}	
}
