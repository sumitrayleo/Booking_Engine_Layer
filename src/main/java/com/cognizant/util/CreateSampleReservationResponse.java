package com.cognizant.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.cognizant.orchestration.dto.PushNotificationResponse;
import com.cognizant.orchestration.exception.BookingApplException;

public class CreateSampleReservationResponse {

	public PushNotificationResponse getSampleFileContent() {
		final File jsonFile = new File(
				Thread.currentThread().getContextClassLoader().getResource("pushNotification.json").getPath());
		final ObjectMapper mapper = new ObjectMapper();
		PushNotificationResponse pushNotificationResponse = null;
		FileInputStream fileInputStream = null;
		try {
			if (jsonFile.exists() && jsonFile.length() != 0) {

				fileInputStream = new FileInputStream(jsonFile);

				pushNotificationResponse = mapper.readValue(fileInputStream, PushNotificationResponse.class);

			}
			return pushNotificationResponse;
		} catch (IOException e) {
			throw new BookingApplException("Error ocurred while retrieving stream");
		}
	}

}
