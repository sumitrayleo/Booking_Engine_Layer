package com.cognizant.orchestration.dto;

public class PushNotifyFcmRQ {

	private String to;
	private PushNotificationSuccessRS data;
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public PushNotificationSuccessRS getData() {
		return data;
	}
	public void setData(PushNotificationSuccessRS data) {
		this.data = data;
	}
	
}
