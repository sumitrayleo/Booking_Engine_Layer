package com.cognizant.transformer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.mule.api.annotations.ContainsTransformerMethods;
import org.mule.api.annotations.Transformer;

import com.cognizant.orchestration.dto.DeviceInformation;
import com.cognizant.orchestration.exception.BookingApplException;

@ContainsTransformerMethods
public class RegisterDeviceToFileTransformer {

	@Transformer
	public InputStream fromDeviceInformationToFile(final DeviceInformation deviceRequest) throws BookingApplException {
		final Properties props = new Properties();
		props.setProperty("DeviceId",
				deviceRequest.getDeviceIds().toString().replaceAll("\\[|\\]", "").replaceAll(", ", ","));
		props.setProperty("AppName", deviceRequest.getAppName());

		final ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			props.store(output, null);
		} catch (IOException e) {
			throw new BookingApplException("Error ocurred while writing to stream");
		}
		final ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
		return input;
	}

}
