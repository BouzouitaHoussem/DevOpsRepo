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

import com.cataloguetheway.center.config.model.Company;
import com.cataloguetheway.center.config.services.CompanyInt;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class CompanyController {
	
	@Autowired
	private CompanyInt companyService;
	
	@GetMapping("/company/all")
	public ResponseEntity<List<Company>> getAllCompany(){
		List<Company> company= companyService.getAllCompany();
		return new ResponseEntity<>(company,HttpStatus.OK);
		
	}

	@GetMapping("/company/by-id/{id}")
	public ResponseEntity<Company> getCompanyByID(@PathVariable("id") Long id){
		Company company = companyService.getById(id);
		return new ResponseEntity<>(company,HttpStatus.OK);
	}
	
	
	@PostMapping("/company/add")
	public ResponseEntity<Company> addCompany(@RequestBody Company company){
		Company newcompany=companyService.add(company);
		return new ResponseEntity<>(newcompany,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/company/update/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable ("id")Long id, @RequestBody Company company){
		Company updatedcompany= companyService.update(company);
		return new ResponseEntity<>(updatedcompany,HttpStatus.OK);
	}
	
	@DeleteMapping("/company/delete/{id}")
	public ResponseEntity<?> deleteCompany(@PathVariable("id") Long id){
		companyService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
