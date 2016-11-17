package com.cognizant.orchestration.dto;

import java.io.Serializable;

import com.cognizant.orchestration.common.dto.ResponseMessageType;

public class LoginRS implements Serializable {
	
	private static final long serialVersionUID = 7811618031835531532L;
	
	private ResponseMessageType responseType;
    private String authorizationToken;

    public ResponseMessageType getResponseType() {
		return responseType;
	}

	public void setResponseType(ResponseMessageType responseType) {
		this.responseType = responseType;
	}
	
    public String getAuthorizationToken() {
        return authorizationToken;
    }

    public void setAuthorizationToken(String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }

}