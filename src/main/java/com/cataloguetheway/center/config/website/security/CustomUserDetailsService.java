package com.cataloguetheway.center.config.website.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cataloguetheway.center.config.website.dto.RoleDto;
import com.cataloguetheway.center.config.website.dto.UserDto;
import com.cataloguetheway.center.config.website.model.WebsiteUser;
import com.cataloguetheway.center.config.website.service.Implementation.WebsiteUserServiceImpl;



@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	WebsiteUserServiceImpl userService;

	
	/*load user from data base by email
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDto userDto = userService.findUserByEmail(email);
		   if (userDto != null) {
	            List<GrantedAuthority> authorities = getUserAuthority(userDto.getRoles());
	            return buildUserForAuthentication(userDto, authorities);
	        } else {
	            throw new UsernameNotFoundException("user with email " + email + " does not exist.");
	        }
	}*/
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	WebsiteUser usuario = userService.getByEmail(email).orElseThrow(()-> new UsernameNotFoundException("email not found"));
        return UserPrincipalFactory.build(usuario);
    }
    
    
    
    
	/*map RoleDto to GrantedAuthority*/
	private List<GrantedAuthority> getUserAuthority(List<RoleDto> roleDtos){
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		for(int i=0 ; i<roleDtos.size();i++) {
			GrantedAuthority role = new SimpleGrantedAuthority(roleDtos.get(i).getAuthority().name());
			roles.add(role);
			
		}
		return roles;
	}
	
	/*map userDto to UserDetails*/
	private UserDetails buildUserForAuthentication(UserDto userDto,List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(userDto.getEmail(), userDto.getPassword(), authorities);
	}

}
