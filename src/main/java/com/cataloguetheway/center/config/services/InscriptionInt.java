package com.cataloguetheway.center.config.services;

import java.util.List;

import com.cataloguetheway.center.config.model.Inscription;


public interface InscriptionInt {

	
	  List<Inscription> getAllInscriptions();
		
	    Inscription add(Inscription insc);
		
	    Inscription getById (Long id);
		
		void delete(Long id);
		
		Inscription update(Inscription insc);
}
