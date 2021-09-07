package com.cataloguetheway.center.config.website.dto.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cataloguetheway.center.config.website.dto.UserDto;
import com.cataloguetheway.center.config.website.model.Role;
import com.cataloguetheway.center.config.website.model.WebsiteUser;



@Component
public class UserDtoToUserMapper {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public WebsiteUser mapUserDtoToUser(UserDto userDto) {
		
		Set<Role> roles=new HashSet<Role>();
		
		
		/*get all the authorities from list of Role and map them to RoleDto List*/
		roles.addAll(userDto.getRoles());
		
		
		
		WebsiteUser user=new WebsiteUser();
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setRoles(roles);	
		
		
		return user;

		
	}
}
