package com.cognizant.orchestration.dto;

import java.io.Serializable;

public class DeviceInformation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String deviceId;
    private String appName;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
