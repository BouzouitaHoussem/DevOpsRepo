package com.cataloguetheway.center.config.services.implem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cataloguetheway.center.config.Dao.EquipementDao;
import com.cataloguetheway.center.config.Dao.EspaceDao;
import com.cataloguetheway.center.config.model.Equipement;
import com.cataloguetheway.center.config.model.Espace;
import com.cataloguetheway.center.config.services.EquipementInt;


@Service
public class EquipementServiceImpl implements EquipementInt{
	
	@Autowired
	private EquipementDao equipRepository;
	
	@Autowired
	private EspaceDao espaceRepo;

	@Override
	public List<Equipement> getAllEquipements() {
		return equipRepository.findAll();
	}

	@Override
	public List<Equipement> GETAllEquipementByEtat() {
		return equipRepository.AllEquipementByEtat();
	}
	
	@Override
	public Equipement add(Equipement eq) {
		return equipRepository.save(eq);
	}

	@Override
	public Equipement getById(Long id) {
		
		Optional<Equipement> eq= equipRepository.findById(id);
		  if(eq.isPresent()) {
			  return eq.get();
		  }
		return null;
	}

	@Override
	public void delete(Long id) {
		equipRepository.deleteById(id);
	}

	@Override
	public Equipement update(Equipement eq) {
		return equipRepository.save(eq);
	}

	@Override
	public List<Equipement> findEquipementByEspace(Long idespce) {
		Espace espace = espaceRepo.findById(idespce).get();
		 List<Equipement>  equips= equipRepository.findEquipementByEspace(espace);
		return equips;
	}



	
}
