package org.chd.entity;

import java.io.Serializable;
/**
 * @hibernate.class
 * table="Type"
 * @author Administrator
 *
 */
public class TypeInfo implements Serializable {

	private Integer typeId;
	private String type;
	public TypeInfo() {
	}
	/**
	 * @hibernate.id
	 * column="TypeId"
	 * generator-class="assigned"
	 */

	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	/**
	 * @hibernate.property
	 * column="Type"
	 * length="20"
	 * not-null="true"
	 */
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	}
	
