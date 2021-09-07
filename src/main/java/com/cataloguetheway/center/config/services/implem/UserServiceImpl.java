package com.cataloguetheway.center.config.services.implem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cataloguetheway.center.config.Dao.UserDao;
import com.cataloguetheway.center.config.model.User;
import com.cataloguetheway.center.config.services.UserInt;



@Service
public class UserServiceImpl implements UserInt {

	@Autowired
	private UserDao userRepository;
	
	
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User add(User u) {
		return userRepository.save(u);
	}

	@Override
	public User getById(Long id) {
		
		Optional<User> u= userRepository.findById(id);
		if( u.isPresent() ) {
			return u.get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {
	 userRepository.deleteById(id);
	}

	@Override
	public User update(User u) {
		return userRepository.save(u);
	}

	
}
