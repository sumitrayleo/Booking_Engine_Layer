package com.cognizant.orchestration.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.cognizant.orchestration.dto.DeviceInformationRQ;
import com.cognizant.orchestration.dto.DeviceInformationRS;

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
	@ApiOperation(value = "Finds device registration details by unique identifiers", response = DeviceInformationRS.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Please provide a valid input") })
	public String retrieveDeviceById(
			@ApiParam(value = "Uuid to find", required = true) @QueryParam("uuid") String uuid,@ApiParam(value = "Region to find", required = true) @QueryParam("region") String region,@ApiParam(value = "Asset Id to find", required = true) @QueryParam("assetId") String assetId) {

		return "RetrieveDeviceDetailsFlow";
	}

	@POST
	@Path("/registerDevice")
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Register Device", response = DeviceInformationRS.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Please provide a valid input") })
	public String registerDevice(
			@ApiParam(value = "Device Details for Registration", required = true) DeviceInformationRQ device) {

		return "DeviceConfigurationFlow";
	}
}
