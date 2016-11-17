package com.cognizant.orchestration.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cognizant.orchestration.dto.PushNotificationRQ;
import com.cognizant.orchestration.dto.PushNotificationRS;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/api/booking/notify/info")
@Api(value = "/api/booking/notify/info", description = "Push notification operations", tags = "push notification")
@Produces({ MediaType.APPLICATION_JSON })
public class PushResource {

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Send Push Notification", response = PushNotificationRS.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Please provide a valid input") })
	public String sendPushNotification(
			@ApiParam(value = "Push Notification Request", required = true) PushNotificationRQ pushNotificationRequest) {

		return "PushNotificationFlow";
	}
}
