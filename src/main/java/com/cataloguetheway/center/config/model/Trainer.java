package com.cataloguetheway.center.config.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Trainer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdTrainer;
	private String nom;
	private String prenom;
	private String mail;
	private String telephone;
	private int number;
	private  Date dateDeNaissance;
	private String dernierDiplome;
	private String specialites;
	private String autres;
	private String cv;
	
	@JsonIgnore
	@OneToMany(mappedBy = "formateur")
	private List<Session> sessions;
	
	
	public Trainer() {
		super();
	}

	public Trainer(Long idTrainer, String nom, String prenom, String mail, String telephone, int number,
			Date dateDeNaissance, String dernierDiplome, String specialites, String autres, String cv,
			List<Session> sessions) {
		super();
		IdTrainer = idTrainer;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.telephone = telephone;
		this.number = number;
		this.dateDeNaissance = dateDeNaissance;
		this.dernierDiplome = dernierDiplome;
		this.specialites = specialites;
		this.autres = autres;
		this.cv = cv;
		this.sessions = sessions;
	}

	public Long getIdTrainer() {
		return IdTrainer;
	}

	public void setIdTrainer(Long idTrainer) {
		IdTrainer = idTrainer;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getDernierDiplome() {
		return dernierDiplome;
	}

	public void setDernierDiplome(String dernierDiplome) {
		this.dernierDiplome = dernierDiplome;
	}

	public String getSpecialites() {
		return specialites;
	}

	public void setSpecialites(String specialites) {
		this.specialites = specialites;
	}

	public String getAutres() {
		return autres;
	}

	public void setAutres(String autres) {
		this.autres = autres;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Trainer [IdTrainer=" + IdTrainer + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail
				+ ", telephone=" + telephone + ", number=" + number + ", dateDeNaissance=" + dateDeNaissance
				+ ", dernierDiplome=" + dernierDiplome + ", specialites=" + specialites + ", autres=" + autres + ", cv="
				+ cv + ", sessions=" + sessions + "]";
	}
	
	
}

