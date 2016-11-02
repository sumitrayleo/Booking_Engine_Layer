package com.cognizant.orchestration.dto;

import java.io.Serializable;
import java.util.List;

public class DeviceInformation implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<AssetInfo> devices;
	private String appName;

	
	public List<AssetInfo> getDevices() {
		return devices;
	}

	public void setDevices(List<AssetInfo> devices) {
		this.devices = devices;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
}
