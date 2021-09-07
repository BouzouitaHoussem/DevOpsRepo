package com.cataloguetheway.center.config.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cataloguetheway.center.config.model.Inscription;
import com.cataloguetheway.center.config.model.RegulatoryTranches;

@Repository
public interface RegulatoryTranchesDao extends JpaRepository<RegulatoryTranches, Long>,JpaSpecificationExecutor<RegulatoryTranches> {
	  List <RegulatoryTranches> findRegulatorytranchesByInscription(Inscription insc);
	}
