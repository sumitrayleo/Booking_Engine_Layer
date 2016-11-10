package com.cognizant.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.codehaus.jackson.map.ObjectMapper;

import com.cognizant.orchestration.dto.AssetInfo;
import com.cognizant.orchestration.dto.DeviceInformationRQ;
import com.cognizant.orchestration.exception.BookingApplException;

public class ReadDeviceInfoUtil {
	@SuppressWarnings("unchecked")
	public DeviceInformationRQ readDeviceInformation(final String filePath, final DeviceInformationRQ deviceRequest) {
		File jsonFile = null;
		FileInputStream fileInputStream = null; 
		try {
			jsonFile = new File(filePath);
			fileInputStream = new FileInputStream(jsonFile);
			final ObjectMapper mapper = new ObjectMapper();
			if (jsonFile.exists() && jsonFile.length() != 0) {
				DeviceInformationRQ existingValue = mapper.readValue(fileInputStream, DeviceInformationRQ.class);
				final List<AssetInfo> newDevices = deviceRequest.getDevices();
				List<AssetInfo> existingDevices = existingValue.getDevices();
				List<AssetInfo> existingCommonDevices = (List<AssetInfo>) CollectionUtils.intersection(newDevices,
						existingDevices);
				existingDevices.removeAll(existingCommonDevices);
				existingDevices.addAll(newDevices);
				deviceRequest.setDevices(existingDevices);
			}
		
		} catch (IOException e) {
			throw new BookingApplException("Error ocurred while writing to stream");
		}
		finally{
			try {
				fileInputStream.close();
			} catch (IOException e) {
				throw new BookingApplException("Error Occurred while closing the file input stream");
			}
			
		}
		return deviceRequest;
	}
}