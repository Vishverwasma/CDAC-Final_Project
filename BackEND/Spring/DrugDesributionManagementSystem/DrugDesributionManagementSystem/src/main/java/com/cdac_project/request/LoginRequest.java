package com.cdac_project.request;

public class LoginRequest {

	private String Email;
	private String password;
	public LoginRequest() {
		super();
	}
	public LoginRequest(String Email, String password) {
		super();
		this.Email = Email;
		this.password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
