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

import com.cataloguetheway.center.config.model.Inscription;
import com.cataloguetheway.center.config.services.InscriptionInt;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class InscriptionController {

	@Autowired 
	private InscriptionInt inscriptionService;
	
	@GetMapping("/inscriptions/all")
	public List<Inscription> getAllInscription(){
		List<Inscription> inscr = inscriptionService.getAllInscriptions();
		return inscr;
		
	}
	
	@GetMapping("/inscription/by-id/{id}")
	public ResponseEntity< Inscription> getInscriptionByID(@PathVariable("id") Long id){
		 Inscription insc = inscriptionService.getById(id);
		return new ResponseEntity<>(insc,HttpStatus.OK);
	}
	
	
	@PostMapping("/inscription/add")
	public ResponseEntity<Inscription> addInscription(@RequestBody Inscription inscp){
		Inscription newinsc=  inscriptionService.add(inscp);
		
		return new ResponseEntity<>(newinsc,HttpStatus.CREATED);
	} 
	

	
	@PutMapping("/inscription/update/{id}")
	public ResponseEntity<Inscription> updateInscription(@PathVariable ("id")Long id, @RequestBody Inscription inscp){
		Inscription updatedinsc= inscriptionService.update(inscp);
		return new ResponseEntity<>(updatedinsc,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/inscription/delete/{id}")
	public ResponseEntity<?> deleteInscription(@PathVariable("id") Long id){
		inscriptionService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
