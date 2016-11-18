package com.cognizant.orchestration.common.dto;

import java.io.Serializable;

public class MessageType implements Serializable{

	private static final long serialVersionUID = -6324177144399334301L;
	private String code;
	private String severity;
	private String fieldName;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
}
