package com.cataloguetheway.center.config.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Equipement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long idEquipement;
	 private String labeleq;
	 private String reference;
	 private String etat;
	 
	 @JsonIgnore
	 @ManyToOne(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
	 private Espace espace;
	 

	public Equipement() {
		super();
	}


	public Equipement(Long idEquipement, String labeleq, String reference, String etat, Espace espace) {
		super();
		this.idEquipement = idEquipement;
		this.labeleq = labeleq;
		this.reference = reference;
		this.etat = etat;
		this.espace = espace;
	}


	public Long getIdEquipement() {
		return idEquipement;
	}

	public void setIdEquipement(Long idEquipement) {
		this.idEquipement = idEquipement;
	}

	public String getLabeleq() {
		return labeleq;
	}

	public void setLabeleq(String labeleq) {
		this.labeleq = labeleq;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Espace getEspace() {
		return espace;
	}

	public void setEspace(Espace espace) {
		this.espace = espace;
	}


	@Override
	public String toString() {
		return "Equipement [idEquipement=" + idEquipement + ", labeleq=" + labeleq + ", reference=" + reference
				+ ", etat=" + etat + ", espace=" + espace + "]";
	}



}
