package com.cataloguetheway.center.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cataloguetheway.center.config.model.User;
import com.cataloguetheway.center.config.services.UserInt;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserInt userService;
	
	
	@GetMapping("/users/all")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
		
	}
	
	@GetMapping("/user/by-id/{id}")
	public ResponseEntity<User> getUserByID(@PathVariable("id") Long id){
		User user= userService.getById(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@PostMapping("/user/add")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User newuser = userService.add(user);
		return new ResponseEntity<>(newuser,HttpStatus.CREATED);
	}
	
	@PutMapping("/user/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id")Long id, @RequestBody User u){
		u.setIdUser(id);
		User updateUser=  userService.update(u);
		return new ResponseEntity<>(updateUser,HttpStatus.OK);
	}
	
	 
	
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
