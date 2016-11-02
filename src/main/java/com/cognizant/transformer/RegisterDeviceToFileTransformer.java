package com.cognizant.transformer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.mule.api.annotations.ContainsTransformerMethods;
import org.mule.api.annotations.Transformer;

import com.cognizant.orchestration.dto.AssetInfo;
import com.cognizant.orchestration.dto.DeviceInformation;
import com.cognizant.orchestration.exception.BookingApplException;

@ContainsTransformerMethods
public class RegisterDeviceToFileTransformer {

	@Transformer
	public InputStream fromDeviceInformationToFile(final DeviceInformation deviceRequest) throws BookingApplException {
		final String filePath = System.getProperty("filePath");
		final Properties props = new Properties();
		try {
		
		props.load(new FileInputStream(filePath.concat("/deviceMapping.txt")));
		for(AssetInfo assetInfo:deviceRequest.getDevices()){
		final String uuidIdInRequest = assetInfo.getUuid();
		final String uuidsinFile = props.getProperty("RegisteredUuids");
		final String uuidIds = StringUtils.isNotEmpty(uuidsinFile)?uuidsinFile.concat(",").concat(uuidIdInRequest):uuidIdInRequest;
		props.setProperty("RegisteredUuids",uuidIds);
		final String uuidKey = "uuid:"+uuidIdInRequest+"_region:"+assetInfo.getRegion()+"_assetId:"+assetInfo.getAssetId();
		props.setProperty(uuidKey,"message:"+ assetInfo.getMessage()+"_longitude:"+assetInfo.getLongitude()+"_latitude:"+assetInfo.getLatitude()+"_locationDetails:"+ assetInfo.getLocationDetails());
		

		}
		final String appNamesInFile = props.getProperty("AppName");
		final String appNameInRequest = deviceRequest.getAppName();
		final String appNames = StringUtils.isNotEmpty(appNamesInFile)?appNamesInFile.concat(",").concat(appNameInRequest):appNameInRequest;		
		props.setProperty("AppName", appNames);

		
		
		final ByteArrayOutputStream output = new ByteArrayOutputStream();
		props.store(output, null);
		final ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
		return input;

		} catch (IOException e) {
			throw new BookingApplException("Error ocurred while writing to stream");
		}
	}

}