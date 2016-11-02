package com.cognizant.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.cognizant.orchestration.dto.AssetInfo;
import com.cognizant.orchestration.exception.BookingApplException;

@Component
public class RetrieveFileContent {

	public AssetInfo getFileContent(String fileName, String deviceIdRequest, String uuidRequest, String regionRequest) {
		AssetInfo asset = new AssetInfo();

		final Properties props = new Properties();
		try {
			props.load(new FileInputStream(fileName));
		} catch (IOException e) {
			throw new BookingApplException("Error ocurred while retrieving stream");
		}
		
		final List<String> uuids = Arrays.asList(props.getProperty("RegisteredUuids").split("\\,"));
		if(uuids.contains(uuidRequest))
			{
				final String uuidKey = "uuid:"+uuidRequest+"_region:"+regionRequest+"_assetId:"+deviceIdRequest;	
				String deviceInfoValue = props.getProperty(uuidKey);
				if(deviceInfoValue!=null){
					
					asset.setAssetId(deviceIdRequest);
					asset.setUuid(uuidRequest);
					asset.setRegion(regionRequest);
					final String[] deviceInfoArray = deviceInfoValue.split("_");
					
					asset.setMessage(populateValue(asset, deviceInfoArray, "message:"));
					asset.setLongitude(populateValue(asset, deviceInfoArray, "longitude:"));
					asset.setLatitude(populateValue(asset, deviceInfoArray, "latitude:"));
					asset.setLocationDetails(populateValue(asset, deviceInfoArray, "locationDetails:"));


				}
				
			}
		
		return asset;
	}

	private String populateValue(AssetInfo asset, String[] deviceInfoArray, final String key) {
		for(String  deviceInfo: deviceInfoArray){
			String[] descriptionArray = deviceInfo.split(key);
			if(!(ArrayUtils.isEmpty(descriptionArray) || descriptionArray.length==1))
			{
				return  descriptionArray[1];	

			} 
			
		}
		return StringUtils.EMPTY;
	}
}
