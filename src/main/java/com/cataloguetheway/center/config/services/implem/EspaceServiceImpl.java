package com.cataloguetheway.center.config.services.implem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cataloguetheway.center.config.Dao.EquipementDao;
import com.cataloguetheway.center.config.Dao.EspaceDao;
import com.cataloguetheway.center.config.model.Espace;
import com.cataloguetheway.center.config.services.EspaceInt;


@Service
public class EspaceServiceImpl implements EspaceInt{

	@Autowired
	EspaceDao espaceRepository;
	
	@Autowired
	EquipementDao equipRepo;

	@Override
	public List<Espace> getAllEspaces() {
		return espaceRepository.findAll();
	}
	
	@Override
	public Espace add(Espace e) {
		Espace newEspace= espaceRepository.save(e);
		
		 if(newEspace.getIdEspace() == null)
		  {
			 newEspace.getEquipements().forEach( equipement -> {
				 equipement.setEspace(newEspace);
				 equipRepo.save(equipement);
				
			 });  
		  }
		return  newEspace;
	}

	@Override
	public Espace getById(Long id) {
		
		Optional<Espace> e= espaceRepository.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {
	   espaceRepository.deleteById(id);
	}

	@Override
	public Espace update(Espace e) {
		return espaceRepository.save(e);
	}


}
