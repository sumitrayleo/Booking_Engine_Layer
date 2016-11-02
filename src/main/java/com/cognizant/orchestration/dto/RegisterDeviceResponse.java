package com.cognizant.orchestration.dto;

import com.cognizant.dto.BaseResponse;

public class RegisterDeviceResponse extends BaseResponse {

	private AssetInfo deviceInfo;

	public AssetInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(AssetInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}



}
