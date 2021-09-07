package com.cataloguetheway.center.config.services;

import java.util.List;

import com.cataloguetheway.center.config.model.Trainer;

public interface TrainerInt {

	 List<Trainer> getAllTrainers();
		
	    Trainer add(Trainer t);
		
	    Trainer getById (Long id);
		
		void delete(Long id);
		
		Trainer update(Trainer t);
}
