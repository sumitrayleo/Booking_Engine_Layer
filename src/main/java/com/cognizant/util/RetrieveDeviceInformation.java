package com.cognizant.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import com.cognizant.orchestration.dto.AssetInfo;
import com.cognizant.orchestration.dto.DeviceInformationRQ;
import com.cognizant.orchestration.exception.BookingApplException;

@Component
public class RetrieveDeviceInformation {

	public AssetInfo getFileContent(final String filePath, final String deviceIdRequest, final String uuidRequest, final String regionRequest) {
		AssetInfo asset = null;

		try {
			final File jsonFile = new File(filePath);
			final ObjectMapper mapper = new ObjectMapper();
			if (jsonFile.exists() && jsonFile.length() != 0) {
				final FileInputStream fileInputStream = new FileInputStream(jsonFile);
				DeviceInformationRQ existingValue = mapper.readValue(fileInputStream, DeviceInformationRQ.class);
				asset = (AssetInfo) CollectionUtils.find(existingValue.getDevices(), new Predicate(){

					@Override
					public boolean evaluate(Object object) {
						final AssetInfo assetInfo = (AssetInfo)object;
						final String assetId = assetInfo.getAssetId();
						final String uuidId = assetInfo.getUuid();
						final String regionId = assetInfo.getRegion();

						return deviceIdRequest.equalsIgnoreCase(assetId)&& uuidRequest.equalsIgnoreCase(uuidId) && regionRequest.equalsIgnoreCase(regionId);
					}});
				fileInputStream.close();
			}
		return asset;
	} catch (IOException e) {
		throw new BookingApplException("Error ocurred while retrieving stream");
	}
	}
	
}
