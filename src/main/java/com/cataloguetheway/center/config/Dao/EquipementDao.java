package com.cataloguetheway.center.config.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cataloguetheway.center.config.model.Equipement;
import com.cataloguetheway.center.config.model.Espace;

@Repository
public interface EquipementDao extends JpaRepository<Equipement, Long>,JpaSpecificationExecutor<Equipement>{
	
	 List <Equipement> findEquipementByEspace(Espace e);
	 
	 @Query(nativeQuery = true, value ="SELECT * FROM equipement e where e.etat LIKE '%Disponible%'")
	public List<Equipement> AllEquipementByEtat();
}

