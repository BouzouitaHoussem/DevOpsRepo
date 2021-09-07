package com.cataloguetheway.center.config.services;

import java.util.List;

import com.cataloguetheway.center.config.model.Company;


public interface CompanyInt {

    List<Company> getAllCompany();
	
    Company add(Company buss);
	
    Company getById (Long id);
	
	void delete(Long id);
	
	Company update(Company buss);
}
