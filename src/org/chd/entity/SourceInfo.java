package org.chd.entity;

import java.io.Serializable;
/**
 * @hibernate.class
 * table="Source"
 * @author Administrator
 *
 */
public class SourceInfo implements Serializable {

	public SourceInfo(Integer sourceId, String source) {
		super();
		this.sourceId = sourceId;
		this.source = source;
	}
	public SourceInfo(){}
	private Integer sourceId;
	private String source;
	/**
	 * @hibernate.id
	 * column="SourceId"
	 * generator-class="assigned"
	 */
	public Integer getSourceId() {
		return sourceId;
	}
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	/**
	 * @hibernate.property
	 * column="Source"
	 * length="10"
	 */
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
}
