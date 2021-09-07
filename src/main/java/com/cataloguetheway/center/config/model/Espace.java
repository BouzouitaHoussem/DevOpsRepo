package com.cataloguetheway.center.config.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Espace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long idEspace;
	private  String lieu;
	private  String type;
	private  int capacite;
	
	
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "espace" ,orphanRemoval = true)
	  Set<Equipement> equipements ;
	 
	public Espace() {
		super();
	}



	public Espace(Long idEspace, String lieu, String type, int capacite, Set<Equipement> equipements) {
		super();
		this.idEspace = idEspace;
		this.lieu = lieu;
		this.type = type;
		this.capacite = capacite;
		this.equipements = equipements;
	}



	public Long getIdEspace() {
		return idEspace;
	}

	public void setIdEspace(Long idEspace) {
		this.idEspace = idEspace;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public Set<Equipement> getEquipements() {
		return equipements;
	}

	public void setEquipements(Set<Equipement> equipements) {
		this.equipements = equipements;
	}

	 
	@Override
	public String toString() {
		return "Espace [idEspace=" + idEspace + ", lieu=" + lieu + ", type=" + type + ", capacite=" + capacite
				+ ", equipements=" + equipements + "]";
	}
}

