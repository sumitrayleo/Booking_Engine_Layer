package com.cognizant.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.cognizant.orchestration.dto.DeviceInformation;
import com.cognizant.orchestration.exception.BookingApplException;

@Component
public class RetrieveFileContent {

	public DeviceInformation getFileContent(String fileName)
	{
		System.out.println("Inside get file content file name " + fileName);
		final Properties props = new Properties();
		try {
		props.load(new FileInputStream(fileName));
		} catch (IOException e) {
			throw new BookingApplException("Error ocurred while retrieving stream");
		}
		final DeviceInformation deviceRequest = new DeviceInformation();
		deviceRequest.setAppName(props.getProperty("AppName"));
		deviceRequest.setDeviceId(props.getProperty("DeviceId"));
		return deviceRequest;
	}
}
