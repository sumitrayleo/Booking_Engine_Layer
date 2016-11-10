package com.cognizant.orchestration.dto;

import java.util.List;

public class ResponseMessageType {

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
