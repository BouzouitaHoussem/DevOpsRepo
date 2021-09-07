package com.cataloguetheway.center.config.website.dto;

import com.cataloguetheway.center.config.website.util.RoleNumber;

public class RoleDto {
	
	private RoleNumber authority;
	
	public RoleDto() {
		
	}
	
	

	public RoleDto(RoleNumber authority) {
		super();
		this.authority = authority;
	}



	public RoleNumber getAuthority() {
		return authority;
	}

	public void setAuthority(RoleNumber authority) {
		this.authority = authority;
	}


	
	

}
