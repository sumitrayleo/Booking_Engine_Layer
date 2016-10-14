package com.cognizant.transformer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.map.ObjectMapper;
import org.mule.api.annotations.ContainsTransformerMethods;
import org.mule.api.annotations.Transformer;

import com.cognizant.orchestration.dto.DeviceInformation;
import com.cognizant.orchestration.exception.BookingApplException;
@ContainsTransformerMethods
public class RegisterDeviceToFileTransformer {
	@Transformer
	public InputStream fromDeviceInformationToFile(final DeviceInformation deviceRequest) throws BookingApplException {
		try {

			final ObjectMapper mapper = new ObjectMapper();
			final ByteArrayInputStream input = new ByteArrayInputStream(mapper.writeValueAsBytes(deviceRequest));
			return input;
		} catch (IOException e) {
			throw new BookingApplException("Error ocurred while writing to stream");
		}
	}
}