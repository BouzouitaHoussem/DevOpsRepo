package com.cataloguetheway.center.config.services;

import java.util.List;

import com.cataloguetheway.center.config.model.RegulatoryTranches;

public interface RegulatoryTranchesInt {
	
List<RegulatoryTranches> getAllRegulatorytranches();
	
    RegulatoryTranches add(RegulatoryTranches regTranches);
	
    RegulatoryTranches getById (Long id);
	
	void delete(Long id);
	
	RegulatoryTranches update(RegulatoryTranches regTranches);
	
	 List <RegulatoryTranches> findRegsTranchesByInscription(Long idinsc);
}
