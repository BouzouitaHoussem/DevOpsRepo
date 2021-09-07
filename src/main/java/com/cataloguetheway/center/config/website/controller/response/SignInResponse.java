package com.cataloguetheway.center.config.website.controller.response;

public class SignInResponse {

	private String jwt;
	private boolean signedIn;

	public SignInResponse() {
		
	}
	
	public SignInResponse(String jwt,boolean signedIn) {
		super();
		this.jwt = jwt;
		this.signedIn=signedIn;
	}

	
	public boolean isSignedIn() {
		return signedIn;
	}

	public void setSignedIn(boolean signedIn) {
		this.signedIn = signedIn;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
}
