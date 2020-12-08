package com.dublin.parkapi.dto;


public class ApiResponse {

	private String errorMessage;

	public ApiResponse() {
	}

	public ApiResponse(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
