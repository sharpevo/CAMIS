package org.chd.entity;

import java.io.Serializable;

/**
 *@hibernate.class table="Field"
 * @author Administrator
 */
public class FieldInfo implements Serializable {

	public FieldInfo(Integer fieldId, String field) {
		super();
		this.fieldId = fieldId;
		this.field = field;
	}

	public FieldInfo() {
	}


	private Integer fieldId;

	private String field;

	/**
	 *@hibernate.id column="FieldId" generator-class="assigned"
	 */
	public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	/**
	 *@hibernate.property column="FieldName" length="50" not-null="true"
	 */
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
}
