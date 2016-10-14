package com.cognizant.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.codehaus.jackson.map.ObjectMapper;

import com.cognizant.orchestration.dto.AssetInfo;
import com.cognizant.orchestration.dto.DeviceInformation;
import com.cognizant.orchestration.exception.BookingApplException;

public class ReadDeviceInfoUtil {
	@SuppressWarnings("unchecked")
	public DeviceInformation readDeviceInformation(final String filePath, final DeviceInformation deviceRequest) throws BookingApplException {
		try {
			final File jsonFile = new File(filePath);
			final ObjectMapper mapper = new ObjectMapper();
			if (jsonFile.exists() && jsonFile.length() != 0) {
				final FileInputStream fileInputStream = new FileInputStream(jsonFile);
				DeviceInformation existingValue = mapper.readValue(fileInputStream, DeviceInformation.class);
				final List<AssetInfo> newDevices = deviceRequest.getDevices();
				List<AssetInfo> existingDevices = existingValue.getDevices();
				List<AssetInfo> existingCommonDevices = (List<AssetInfo>) CollectionUtils.intersection(newDevices,
						existingDevices);
				existingDevices.removeAll(existingCommonDevices);
				existingDevices.addAll(newDevices);
				deviceRequest.setDevices(existingDevices);
				fileInputStream.close();
			}
		
		} catch (IOException e) {
			throw new BookingApplException("Error ocurred while writing to stream");
		}
		return deviceRequest;
	}
}