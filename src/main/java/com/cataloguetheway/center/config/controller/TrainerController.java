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

import com.cataloguetheway.center.config.model.Trainer;
import com.cataloguetheway.center.config.services.TrainerInt;



@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class TrainerController {

	@Autowired
	private TrainerInt trainerService;
	
	@GetMapping("/trainers/all")
	public ResponseEntity<List<Trainer>> getAlltrainer(){
		List<Trainer> trainer = trainerService.getAllTrainers();
		return new ResponseEntity<>(trainer,HttpStatus.OK);
	}
	
	
	@GetMapping("/gettrainer/{id}")
	public ResponseEntity<Trainer> getTrainerByID(@PathVariable("id") Long id){
		Trainer Trainer= trainerService.getById(id);
		return new ResponseEntity<>(Trainer,HttpStatus.OK);
	}
	
	
	@PostMapping("/trainer/add")
	public ResponseEntity<Trainer> addTrainer(@RequestBody Trainer T){
		Trainer newTrainer = trainerService.add(T);
		return new ResponseEntity<>(newTrainer,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/trainer/update/{id}")
	public ResponseEntity<Trainer > updateTrainer (@PathVariable ("id")Long id, @RequestBody Trainer  trainer){
		Trainer  updatetrainer=  trainerService.update(trainer);
		return new ResponseEntity<>(updatetrainer,HttpStatus.OK);
	}
	
	@DeleteMapping("/trainer/delete/{id}")
	public ResponseEntity<?> deletetrainer(@PathVariable("id") Long id){
		trainerService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
