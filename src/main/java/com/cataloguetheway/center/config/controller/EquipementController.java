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

import com.cataloguetheway.center.config.model.Equipement;
import com.cataloguetheway.center.config.services.EquipementInt;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class EquipementController {
	
	@Autowired
	private EquipementInt eqService;
	

	@GetMapping("/equipements/all")
	public ResponseEntity<List<Equipement>> getAllEquipement(){
		List<Equipement> equip = eqService.getAllEquipements();
		return new ResponseEntity<>(equip,HttpStatus.OK);
		
	}
	
	@GetMapping("/equipementsByEtat/all")
	public ResponseEntity<List<Equipement>> getAllEquipementByEtat(){
		List<Equipement> equipement = eqService.GETAllEquipementByEtat();
		return new ResponseEntity<>(equipement,HttpStatus.OK);
		
	}

	@GetMapping("/equipement/by-id/{id}")
	public ResponseEntity<Equipement> getEquipementByID(@PathVariable("id") Long id){
		Equipement eq = eqService.getById(id);
		return new ResponseEntity<>(eq,HttpStatus.OK);
	}
	
	@PostMapping("/equipement/add")
	public ResponseEntity<Equipement> addEquipement(@RequestBody Equipement eq){
		Equipement neweq=  eqService.add(eq);
		return new ResponseEntity<>(neweq,HttpStatus.CREATED);
	}
	

	@PutMapping("/equipement/update/{id}")
	public ResponseEntity<Equipement> updateEquipement(@PathVariable("id")Long id, @RequestBody Equipement eq){
		eq.setIdEquipement(id);
		Equipement updatedEquipement= eqService.update(eq);
		return new ResponseEntity<>(updatedEquipement,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/equipement/delete/{id}")
	public ResponseEntity<?> deleteEquipement(@PathVariable("id") Long id){
		eqService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/equipsByEspace/{id}")
	public ResponseEntity<List<Equipement>> getEquipementsByEspace(@PathVariable("id") Long id){
		List<Equipement> equipsByEspacee = eqService.findEquipementByEspace(id);
		return new ResponseEntity<>( equipsByEspacee,HttpStatus.OK);
	}
}
