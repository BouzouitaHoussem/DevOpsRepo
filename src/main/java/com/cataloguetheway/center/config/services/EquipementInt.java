package com.cataloguetheway.center.config.services;

import java.util.List;

import com.cataloguetheway.center.config.model.Equipement;


public interface EquipementInt {

	  List<Equipement> getAllEquipements();
	    
	    List<Equipement> GETAllEquipementByEtat();
		
	    Equipement add(Equipement eq);
		
	    Equipement getById (Long id);
		
		void delete(Long id);
		
		Equipement update(Equipement eq);
		
		List <Equipement> findEquipementByEspace(Long idespce);
}
