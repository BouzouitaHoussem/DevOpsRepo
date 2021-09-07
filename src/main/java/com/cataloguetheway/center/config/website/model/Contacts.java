package com.cataloguetheway.center.config.website.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contacts {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String firstPhone;
	private String secondPhone;
	private String facebookUrl;
	private String linkedinUrl;
	private String instagramUrl;
	private String twitterUrl;
	
	public Contacts() {
		
	}
	
	public Contacts(Long id, String email, String firstPhone, String secondPhone, String facebookUrl,
			String linkedinUrl, String instagramUrl, String twitterUrl) {
		super();
		this.id = id;
		this.email = email;
		this.firstPhone = firstPhone;
		this.secondPhone = secondPhone;
		this.facebookUrl = facebookUrl;
		this.linkedinUrl = linkedinUrl;
		this.instagramUrl = instagramUrl;
		this.twitterUrl = twitterUrl;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstPhone() {
		return firstPhone;
	}
	public void setFirstPhone(String firstPhone) {
		this.firstPhone = firstPhone;
	}
	public String getSecondPhone() {
		return secondPhone;
	}
	public void setSecondPhone(String secondPhone) {
		this.secondPhone = secondPhone;
	}
	public String getFacebookUrl() {
		return facebookUrl;
	}
	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}
	public String getLinkedinUrl() {
		return linkedinUrl;
	}
	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}
	public String getInstagramUrl() {
		return instagramUrl;
	}
	public void setInstagramUrl(String instagramUrl) {
		this.instagramUrl = instagramUrl;
	}
	public String getTwitterUrl() {
		return twitterUrl;
	}
	public void setTwitterUrl(String twitterUrl) {
		this.twitterUrl = twitterUrl;
	}
	
	
	
	
}
