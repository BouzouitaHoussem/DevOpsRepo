package com.cataloguetheway.center.config.website.controller.response;

public class SignUpResponse {

	private String message;
	private boolean registred;
	
	
	SignUpResponse(){
		
	}
	
	

	public SignUpResponse(String message,boolean registred) {
		super();
		this.message = message;
		this.registred=registred;
	}
	
	



	public boolean isRegistred() {
		return registred;
	}



	public void setRegistred(boolean registred) {
		this.registred = registred;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
