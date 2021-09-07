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

import com.cataloguetheway.center.config.model.RegulatoryTranches;
import com.cataloguetheway.center.config.services.RegulatoryTranchesInt;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class RegulatorytranchesController {
	
	@Autowired
	private RegulatoryTranchesInt regTranchesService;

	@GetMapping("/regTranches/all")
	public ResponseEntity<List<RegulatoryTranches>> getAllRegulatorytranches(){
		List<RegulatoryTranches> regtranches = regTranchesService.getAllRegulatorytranches();
		return new ResponseEntity<>(regtranches,HttpStatus.OK);
		
	}
	
	@GetMapping("/regTranchesByInsciption/{id}")
	public ResponseEntity<List<RegulatoryTranches>> getRegTranchsByInscription(@PathVariable("id") Long id){
		List<RegulatoryTranches> regTByInscription = regTranchesService.findRegsTranchesByInscription(id);
		return new ResponseEntity<>( regTByInscription ,HttpStatus.OK);
	}	
	
	
	@GetMapping("/regTranches/by-id/{id}")
	public ResponseEntity<RegulatoryTranches> getRegulatorytranchesByID(@PathVariable("id") Long id){
		 RegulatoryTranches regtranche  = regTranchesService.getById(id);
		return new ResponseEntity<>(regtranche,HttpStatus.OK);
	}
	
	
	@PostMapping("/regTranches/add")
	public ResponseEntity<RegulatoryTranches> addRegulatorytranches(@RequestBody RegulatoryTranches regtranche){
		RegulatoryTranches newregTranche=  regTranchesService.add(regtranche);
		return new ResponseEntity<>(newregTranche,HttpStatus.CREATED);
	}
	
	

	@PutMapping("/regTranches/update/{id}")
	public ResponseEntity<RegulatoryTranches> updateRegulatorytranches(@PathVariable ("id")Long id, @RequestBody RegulatoryTranches regTranches){
		RegulatoryTranches updateregtranche= regTranchesService.update(regTranches);
		return new ResponseEntity<>(updateregtranche,HttpStatus.OK);
	}
	
	

	@DeleteMapping("/regTranches/delete/{id}")
	public ResponseEntity<?> deleteRegulatorytranches(@PathVariable("id") Long id){
		regTranchesService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
