package com.cognizant.orchestration.dto;

public class PushNotifyGCMRequest {

	private String to;
	private PushNotificationResponse data;
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public PushNotificationResponse getData() {
		return data;
	}
	public void setData(PushNotificationResponse data) {
		this.data = data;
	}
	
}
