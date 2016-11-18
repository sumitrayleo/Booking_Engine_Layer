package com.cognizant.orchestration.common.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseMessageType implements Serializable{

	private static final long serialVersionUID = 8222676967377470362L;
	private int statusCode;
	private List<MessageType> messages;
	private String technicalMessages;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public List<MessageType> getMessages() {
		return messages;
	}
	public void setMessages(List<MessageType> messages) {
		this.messages = messages;
	}
	public String getTechnicalMessages() {
		return technicalMessages;
	}
	public void setTechnicalMessages(String technicalMessages) {
		this.technicalMessages = technicalMessages;
	}
	
}
