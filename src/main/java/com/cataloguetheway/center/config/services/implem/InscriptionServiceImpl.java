package com.cataloguetheway.center.config.services.implem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cataloguetheway.center.config.Dao.InscriptionDao;
import com.cataloguetheway.center.config.Dao.RegulatoryTranchesDao;
import com.cataloguetheway.center.config.model.Inscription;
import com.cataloguetheway.center.config.services.InscriptionInt;


@Service
public class InscriptionServiceImpl implements InscriptionInt {

	@Autowired
	private InscriptionDao inscriptionRepository;
	
	@Autowired
	private RegulatoryTranchesDao regRepositpry;
	
	
	@Override
	public List<Inscription> getAllInscriptions() {
		return inscriptionRepository.findAll();
	}

	@Override
	public Inscription add(Inscription insc) {
		Inscription result= inscriptionRepository.save(insc);
		 if(result.getId_sessionsub() != null)
		  {
			 result.getTranchesRegls().forEach( regtranche -> {
				 regtranche.setInscription(result);
				 regRepositpry.save(regtranche);
			 });  
		  }
		return result;
	}

	@Override
	public Inscription getById(Long id) {
		
		Optional<Inscription> insc= inscriptionRepository.findById(id);
		  
		if(insc.isPresent()) {
			   return insc.get();
		   }
		return null;
	}

	@Override
	public void delete(Long id) {
      inscriptionRepository.deleteById(id);
	}

	@Override
	public Inscription update(Inscription insc) {
		return inscriptionRepository.save(insc);
	}
	
}
