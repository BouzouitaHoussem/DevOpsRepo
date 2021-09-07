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

import com.cataloguetheway.center.config.model.Espace;
import com.cataloguetheway.center.config.services.EspaceInt;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class EspaceController {
	
	@Autowired
	private EspaceInt espaceService;

	
	@GetMapping("/espaces/all")
	public ResponseEntity<List<Espace>> getAllEspace(){
		List<Espace> esp = espaceService.getAllEspaces();
		return new ResponseEntity<>(esp,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/espace/by-id/{id}")
	public ResponseEntity<Espace> getEspaceByID(@PathVariable("id") Long id){
		Espace espace = espaceService.getById(id);
		return new ResponseEntity<>(espace,HttpStatus.OK);
	}
	
	@PostMapping("/espace/add")
	public ResponseEntity<Espace> addEspace(@RequestBody Espace espace){
		Espace newespace= espaceService.add(espace);
		return new ResponseEntity<>(newespace,HttpStatus.CREATED);
	}
	
	@PutMapping(path="/espace/update/{id}")
	public Espace updateEspace(@PathVariable ("id")Long id,@RequestBody Espace e){
		return espaceService.update(e);
	}
	
	
	@DeleteMapping("/espace/delete/{id}")
	public ResponseEntity<?> deleteEspace(@PathVariable("id") Long id){
		espaceService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
