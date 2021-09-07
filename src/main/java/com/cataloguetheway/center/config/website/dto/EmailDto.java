package com.cataloguetheway.center.config.website.dto;

public class EmailDto {
	
	private String text;
	private String email;
	private String name;
	
	public EmailDto() {
		
	}
	
	public EmailDto(String text, String email,String name) {
		super();
		this.text = text;

		this.email = email;
		this.name=name;
	}


	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String from) {
		this.email = from;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
