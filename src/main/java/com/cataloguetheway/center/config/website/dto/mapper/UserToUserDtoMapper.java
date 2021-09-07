package com.cataloguetheway.center.config.website.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cataloguetheway.center.config.website.dto.RoleDto;
import com.cataloguetheway.center.config.website.dto.UserDto;
import com.cataloguetheway.center.config.website.model.WebsiteUser;



@Component
public class UserToUserDtoMapper {


	public UserDto mapUserToUserDto(WebsiteUser user) {
		
		List<RoleDto> rolesDto=new ArrayList<RoleDto>();
		RoleDto roleDto = new RoleDto();
		
		/*get all the authorities from list of Role and map them to RoleDto Listx
		for (int i=0; i<user.getRoles().size();i++) {			
			roleDto.setAuthority(user.getRoles().get(i).getAuthority());
			rolesDto.add(roleDto);
		}
		
		
		
		UserDto userDto=new UserDto();
		
		userDto.setEmail(user.getEmail());
		userDto.setFullName(user.getFullName());
		userDto.setPassword(user.getPassword());
		userDto.setPhone(user.getPhone());
		userDto.setRoles(rolesDto);	
		
		
		return userDto;*/
		return null;
	}

}
