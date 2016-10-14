package com.cognizant.orchestration.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.cognizant.dto.BaseResponse;
import com.cognizant.orchestration.dto.DeviceInformation;
import com.cognizant.orchestration.dto.RegisterDeviceResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/info/booking/device")
@Api(value = "/info/booking/device/", description = "Device operations", tags = "device")
@Produces({ MediaType.APPLICATION_JSON })
public class DeviceResource {

	@GET
	@Path("/retrieveDeviceById")
	@ApiOperation(value = "Finds device by Ids", response = RegisterDeviceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Please provide a valid input") })
	public String retrieveDeviceById(
			@ApiParam(value = "Device Ids to find", required = true, allowMultiple = true) @QueryParam("deviceIds") List<String> deviceIds) {

		return "RetrieveDeviceDetailsFlow";
	}

	@POST
	@Path("/registerDevice")
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Register Device", response = BaseResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 405, message = "Please provide a valid input") })
	public String registerDevice(
			@ApiParam(value = "Device Id and App Name ", required = true) DeviceInformation device) {

		return "DeviceConfigurationFlow";
	}
}
