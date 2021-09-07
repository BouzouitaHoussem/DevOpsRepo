package com.cataloguetheway.center.config.website.controller.response;

public class ContactEmailResponse {
	private String response;
	private boolean sent;
	
	public ContactEmailResponse(){
		
	}
	

	public ContactEmailResponse(String response,boolean sent) {
		this.response = response;
		this.sent = sent;
	}


	public boolean isSent() {
		return sent;
	}


	public void setSent(boolean sent) {
		this.sent = sent;
	}


	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	

}
