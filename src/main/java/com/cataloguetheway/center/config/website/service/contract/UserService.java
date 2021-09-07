package com.cataloguetheway.center.config.website.service.contract;

import com.cataloguetheway.center.config.website.dto.UserDto;

public interface UserService {

	/*register a new user*/
	public UserDto signup(UserDto userDto);
	
	/*check if user exist*/
	public boolean checkIfExist(String email);
	/*find a user by email*/
	public UserDto findUserByEmail(String email);
	
	/*update a user*/
	public UserDto updateUser(UserDto userDto);
	
	/*change password*/
	public UserDto changePassword(UserDto userDto,String newPassword);
	
	
}
