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

import com.cataloguetheway.center.config.model.Meeting;
import com.cataloguetheway.center.config.services.MeetingInt;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class MeetingController {
  
	
	@Autowired 
	private MeetingInt meetingService;
	
	@GetMapping("/seances/all")
	public List<Meeting> getAllMeeting(){
		List<Meeting> seances = meetingService.getAllMeetings();
		return seances;
		
	}
	
	@GetMapping("/seance/by-id/{id}")
	public ResponseEntity<Meeting> getMeetingByID(@PathVariable("id") Long id){
		Meeting seance = meetingService.getById(id);
		return new ResponseEntity<>(seance,HttpStatus.OK);
	}
	
	
	@PostMapping("/seance/add")
	public ResponseEntity<Meeting> addMeeting(@RequestBody Meeting meeting){
		Meeting newMeeting=  meetingService.add(meeting);
		
		return new ResponseEntity<>(newMeeting,HttpStatus.CREATED);
	} 
	

	
	@PutMapping("/seance/update/{id}")
	public ResponseEntity<Meeting> updateMeeting(@PathVariable ("id")Long id, @RequestBody Meeting m){
		Meeting updateMeeting= meetingService.update(m);
		return new ResponseEntity<>(updateMeeting,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/seance/delete/{id}")
	public ResponseEntity<?> deleteMeeting(@PathVariable("id") Long id){
		meetingService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
