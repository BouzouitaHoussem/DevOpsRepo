package com.cataloguetheway.center.config.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class RegulatoryTranches {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_TranchesRegls;
	private Date tranchesReglementsDate;
	private int tranchesReglementsMontant;
	
	@ManyToOne
	private Inscription inscription;

	
	public RegulatoryTranches() {
		super();
	}

	public RegulatoryTranches(Long id_TranchesRegls, Date tranchesReglementsDate, int tranchesReglementsMontant,
			Inscription inscription) {
		super();
		this.id_TranchesRegls = id_TranchesRegls;
		this.tranchesReglementsDate = tranchesReglementsDate;
		this.tranchesReglementsMontant = tranchesReglementsMontant;
		this.inscription = inscription;
	}

	public Long getId_TranchesRegls() {
		return id_TranchesRegls;
	}

	public void setId_TranchesRegls(Long id_TranchesRegls) {
		this.id_TranchesRegls = id_TranchesRegls;
	}

	public Date getTranchesReglementsDate() {
		return tranchesReglementsDate;
	}

	public void setTranchesReglementsDate(Date tranchesReglementsDate) {
		this.tranchesReglementsDate = tranchesReglementsDate;
	}

	public int getTranchesReglementsMontant() {
		return tranchesReglementsMontant;
	}

	public void setTranchesReglementsMontant(int tranchesReglementsMontant) {
		this.tranchesReglementsMontant = tranchesReglementsMontant;
	}

	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}

	@Override
	public String toString() {
		return "Regulatorytranches [id_TranchesRegls=" + id_TranchesRegls + ", tranchesReglementsDate="
				+ tranchesReglementsDate + ", tranchesReglementsMontant=" + tranchesReglementsMontant + ", inscription="
				+ inscription + "]";
	}
	
	

}

