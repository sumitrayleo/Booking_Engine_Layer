package com.cognizant.orchestration.dto;

import java.util.List;

import com.cognizant.dto.BaseResponse;

public class RegisterDeviceResponse extends BaseResponse {

	private List<String> deviceIds;

	public List<String> getDeviceIds() {
		return deviceIds;
	}

	public void setDeviceIds(List<String> deviceIds) {
		this.deviceIds = deviceIds;
	}

}
