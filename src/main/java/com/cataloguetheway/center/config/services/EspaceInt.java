package com.cataloguetheway.center.config.services;

import java.util.List;

import com.cataloguetheway.center.config.model.Espace;


public interface EspaceInt {
	
	List<Espace> getAllEspaces();
	
	Espace add(Espace e);
	
	Espace getById (Long id);
	
	void delete(Long id);
	
	Espace update(Espace e);
}
