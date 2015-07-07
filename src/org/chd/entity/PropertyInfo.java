package org.chd.entity;

import java.io.Serializable;
/**
 * @hibernate.class
 * table="Property"
 */
public class PropertyInfo implements Serializable {

	public PropertyInfo(Integer propertyId, String property) {
		super();
		this.propertyId = propertyId;
		this.property = property;
	}
	public PropertyInfo(){}
	
	private Integer propertyId;
	private String property;
	/**
	 *@hibernate.id
	 *column="PropertyId"
	 *generator-class="assigned"
	 *
	 */
	public Integer getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}
	/**
	 * @hibernate.property
	 * column="Property"
	 * length="20"
	 */
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}	
}
