package com.cdac_project.response;

public class AuthResponse {

	private String message;
	public AuthResponse() {
		super();
	}
	public AuthResponse(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
