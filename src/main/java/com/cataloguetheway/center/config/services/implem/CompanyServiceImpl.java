package com.cataloguetheway.center.config.services.implem;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cataloguetheway.center.config.Dao.CompanyDao;
import com.cataloguetheway.center.config.model.Company;
import com.cataloguetheway.center.config.services.CompanyInt;



@Service
public class CompanyServiceImpl implements CompanyInt {
	
	@Autowired
	private CompanyDao companyRepository;

	@Override
	public List<Company> getAllCompany() {
		return companyRepository.findAll();
	}

	@Override
	public Company add(Company c) {
		return companyRepository.save(c);
	}

	@Override
	public Company getById(Long id) {
		
		Optional<Company> entpse= companyRepository.findById(id);
		  if(entpse.isPresent()) {
			  return entpse.get();
		  }
		return null;
	}

	@Override
	public void delete(Long id) {
		companyRepository.deleteById(id);
	}

	@Override
	public Company update(Company c) {
		return companyRepository.save(c);
	}

}
