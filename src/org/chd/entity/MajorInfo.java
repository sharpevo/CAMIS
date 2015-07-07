package org.chd.entity;

import java.io.Serializable;
/**
 *@hibernate.class
 * table="Major"
 * @author Administrator
 *
 */
public class MajorInfo implements Serializable {

	public MajorInfo(){}
	private String majorId;
	private String majorName;
	/**
	 *@hibernate.id
	 * column="MajorId"
	 * generator-class="native"
	 */
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	/**
	 * @hibernate.property
	 * column="Major"
	 * length="20"
	 * not-null="true"
	 */
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String major) {
		this.majorName = major;
	}
	
}
