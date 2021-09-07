package com.cataloguetheway.center.config.website.dto.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cataloguetheway.center.config.website.controller.request.SignUpRequest;
import com.cataloguetheway.center.config.website.dto.UserDto;
import com.cataloguetheway.center.config.website.model.Role;
import com.cataloguetheway.center.config.website.repository.RoleRepository;
import com.cataloguetheway.center.config.website.util.RoleNumber;


@Component
public class SignUpRequestToUserDtoMapper {
	@Autowired
	RoleRepository roleRepository;
	
	public UserDto MapSignUpRequestToUserDto(SignUpRequest signUpRequest) {
		UserDto userDto = new UserDto();
		Role role = new Role();
		role.setRoleNumber(RoleNumber.ROLE_USER);
		roleRepository.save(role);
		Set<Role> roles=new HashSet<Role>();
		roles.add(role);
		userDto.setEmail(signUpRequest.getEmail());	
		userDto.setPassword(signUpRequest.getPassword());	
		userDto.setRoles(roles);
		
		return userDto;
	}

}
