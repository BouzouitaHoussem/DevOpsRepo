package com.cataloguetheway.center.config.website.dto;

import java.util.Set;

import com.cataloguetheway.center.config.website.model.Role;





public class UserDto {
	
	private String email;
	private String password;
	
	private Set<Role> roles;
	
	public UserDto() {
		
	}
	

	public UserDto(String email, String password, Set<Role> roles) {
		super();
		this.email = email;
		this.password = password;
		this.roles = roles;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
