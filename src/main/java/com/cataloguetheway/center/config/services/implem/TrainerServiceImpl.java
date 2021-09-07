package com.cataloguetheway.center.config.services.implem;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cataloguetheway.center.config.Dao.TrainerDao;
import com.cataloguetheway.center.config.model.Trainer;
import com.cataloguetheway.center.config.services.TrainerInt;


@Service
public class TrainerServiceImpl implements TrainerInt {

	
	@Autowired
	private TrainerDao trainerRepo;
	
	@Override
	public List<Trainer> getAllTrainers() {
		return trainerRepo.findAll();
	}

	@Override
	public Trainer add(Trainer t) {
		return trainerRepo.save(t);
	}

	@Override
	public Trainer getById(Long id) {
		
		Optional<Trainer> t= trainerRepo.findById(id);
		 if(t.isPresent()) {
			 return t.get();
		 }
		return null;
	}

	@Override
	public void delete(Long id) {
		trainerRepo.deleteById(id);
	}

	@Override
	public Trainer update(Trainer t) {
		return trainerRepo.save(t);
	}

}
