package com.cataloguetheway.center.config.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Session {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSession;
	private String reference;
	private String titre;
	private String statut;
	private Date datedebut;
	private Date datefin;
	private int nbreplaces;
	
	
	@ManyToOne
	private Trainer formateur;
	
	
	@ManyToOne
	private Training formation;
	
	 @OneToMany(mappedBy = "session")
	 private Set<Inscription> inscriptions;
	 
	 @OneToMany(mappedBy = "meetingsession")
	 private Set<Meeting> seances;

	 
	 
	public Session() {
		super();
	}


	public Session(Long idSession, String reference, String titre, String statut, Date datedebut, Date datefin,
			int nbreplaces, Trainer formateur, Training formation, Set<Inscription> inscriptions,
			Set<Meeting> seances) {
		super();
		this.idSession = idSession;
		this.reference = reference;
		this.titre = titre;
		this.statut = statut;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.nbreplaces = nbreplaces;
		this.formateur = formateur;
		this.formation = formation;
		this.inscriptions = inscriptions;
		this.seances = seances;
	}


	public Long getIdSession() {
		return idSession;
	}

	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public int getNbreplaces() {
		return nbreplaces;
	}

	public void setNbreplaces(int nbreplaces) {
		this.nbreplaces = nbreplaces;
	}


	public Trainer getFormateur() {
		return formateur;
	}

	public void setFormateur(Trainer formateur) {
		this.formateur = formateur;
	}

	public Set<Meeting> getSeances() {
		return seances;
	}

	public void setSeances(Set<Meeting> seances) {
		this.seances = seances;
	}

	public Set<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public Training getFormation() {
		return formation;
	}

	public void setFormation(Training formation) {
		this.formation = formation;
	}


	@Override
	public String toString() {
		return "Session [idSession=" + idSession + ", reference=" + reference + ", titre=" + titre + ", statut="
				+ statut + ", datedebut=" + datedebut + ", datefin=" + datefin + ", nbreplaces=" + nbreplaces
				+ ", formateur=" + formateur + ", formation=" + formation + ", inscriptions=" + inscriptions
				+ ", seances=" + seances + "]";
	}


	 
}

