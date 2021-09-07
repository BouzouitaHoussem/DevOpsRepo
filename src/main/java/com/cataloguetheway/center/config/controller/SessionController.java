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
import com.cataloguetheway.center.config.model.Session;
import com.cataloguetheway.center.config.services.SessionInt;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class SessionController {
	
	@Autowired
	private SessionInt sessionService;
	
	@GetMapping("/sessions/all")
	public ResponseEntity<List<Session>> getAllSession(){
		List<Session> session = sessionService.getAllSessions();
		return new ResponseEntity<>(session,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/session/by-id/{id}")
	public ResponseEntity<Session> getSessionByID(@PathVariable("id") Long id){
		Session session = sessionService.getById(id);
		return new ResponseEntity<>(session,HttpStatus.OK);
	}
	
	@PostMapping("/session/add")
	public ResponseEntity<Session> addSession(@RequestBody Session session){
		Session newSession= sessionService.add(session);
		return new ResponseEntity<>(newSession,HttpStatus.CREATED);
	}
	
	@PutMapping(path="/session/update/{id}")
	public Session updateSession(@PathVariable ("id")Long id,@RequestBody Session s){
		return sessionService.update(s);
	}
	
	
	@DeleteMapping("/session/delete/{id}")
	public ResponseEntity<?> deleteSession(@PathVariable("id") Long id){
		sessionService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
