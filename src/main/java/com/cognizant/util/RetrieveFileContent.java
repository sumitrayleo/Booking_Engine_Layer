package com.cognizant.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.cognizant.orchestration.dto.DeviceInformation;
import com.cognizant.orchestration.exception.BookingApplException;

@Component
public class RetrieveFileContent {

	public DeviceInformation getFileContent(String fileName) {
		final Properties props = new Properties();
		try {
			props.load(new FileInputStream(fileName));
		} catch (IOException e) {
			throw new BookingApplException("Error ocurred while retrieving stream");
		}
		final DeviceInformation deviceRequest = new DeviceInformation();
		deviceRequest.setAppName(props.getProperty("AppName"));
		final List<String> deviceIds = Arrays.asList(props.getProperty("DeviceId").split("\\,"));
		deviceRequest.setDeviceIds(deviceIds);
		return deviceRequest;
	}
}
