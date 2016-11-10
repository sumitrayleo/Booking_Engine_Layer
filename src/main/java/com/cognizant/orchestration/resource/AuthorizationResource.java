package com.cognizant.orchestration.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cognizant.dto.LoginRequest;
import com.cognizant.dto.LoginResponse;
import com.cognizant.orchestration.dto.BaseResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/api/booking/")
@Api(value = "/api/booking/", description = "Authorization  operations-Login ,LogOut", tags = "authorization")
@Produces({ MediaType.APPLICATION_JSON })
public class AuthorizationResource {
	@POST
	@Path("/login")
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Login User", response = LoginResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Please provide valid username and password") })
	public String login(
			@ApiParam(value = "Login Request ", required = true) LoginRequest login) {

		return "LoginFlow";
	}

	@POST
	@Path("/logout")
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Logout User", response = BaseResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Please provide a valid input") })
	public String logout() {

		return "LogoutFlow";
	}
}
