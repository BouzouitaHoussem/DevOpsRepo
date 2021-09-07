package com.cataloguetheway.center.config.services;

import java.util.List;

import com.cataloguetheway.center.config.model.User;


public interface UserInt {

	 List<User> getAllUsers();
		
	    User add(User u);
		
	    User getById (Long id);
		
		void delete(Long id);
		
		User update(User u);
}
