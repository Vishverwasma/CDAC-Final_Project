package com.cdac_project.response;

public class MedicineResponse {
	private String message;
	public MedicineResponse() {
		super();
	}
	public MedicineResponse(String message) {
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
