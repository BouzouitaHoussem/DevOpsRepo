package com.cataloguetheway.center.config.services.implem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cataloguetheway.center.config.Dao.InscriptionDao;
import com.cataloguetheway.center.config.Dao.RegulatoryTranchesDao;
import com.cataloguetheway.center.config.model.Inscription;
import com.cataloguetheway.center.config.model.RegulatoryTranches;
import com.cataloguetheway.center.config.services.RegulatoryTranchesInt;


@Service
public class RegulatorytranchesServiceImpl implements RegulatoryTranchesInt {

	
	@Autowired
	private RegulatoryTranchesDao regtranchesRepository;
	
	@Autowired
	private InscriptionDao inscRepo;
	
	@Override
	public List<RegulatoryTranches> getAllRegulatorytranches() {
		return regtranchesRepository.findAll();
	}

	@Override
	public RegulatoryTranches add(RegulatoryTranches regTranches) {
		return regtranchesRepository.save(regTranches);
	}

	@Override
	public RegulatoryTranches getById(Long id) {
		
		Optional<RegulatoryTranches>  regTranches= regtranchesRepository.findById(id);
		  
		  if(regTranches.isPresent()) {
			 return regTranches.get(); 
		 }
		return null;
	}

	@Override
	public void delete(Long id) {
		regtranchesRepository.deleteById(id);
	}

	@Override
	public RegulatoryTranches update(RegulatoryTranches regTranches) {
		return regtranchesRepository.save(regTranches);
	}

	@Override
	public List<RegulatoryTranches> findRegsTranchesByInscription(Long idinsc) {
		Inscription inscription =inscRepo.findById(idinsc).get();
		 List<RegulatoryTranches>  regtranches= regtranchesRepository.findRegulatorytranchesByInscription(inscription);
		return regtranches;
	}


}
