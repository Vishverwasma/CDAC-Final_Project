package com.cdac_project.project.request;

public class LoginRequest {

	private String Email;
	private String passoword;
	public LoginRequest() {
		super();
	}
	public LoginRequest(String Email, String passoword) {
		super();
		this.Email = Email;
		this.passoword = passoword;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getPassoword() {
		return passoword;
	}
	public void setPassoword(String passoword) {
		this.passoword = passoword;
	}
	
}
