package com.cataloguetheway.center.config.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="Participant")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	private String nom;
	private String prenom;
	private String adresse;
	private String rue;
	private int cp;
	@JsonIgnore
	private String ville;
	private String pays;
	private String tel_Mob;
	private String tel_Fixe;
	private String email_perso;
	private String email_pro;
	private String fonction;
	private String commentaire;
	private String particulier_professionnel;
	
	@ManyToOne
	private Company societe;
	
	@OneToMany(mappedBy = "participant")
	@JsonIgnore
	private Set<Inscription> inscriptions;
	
	public User() {
		super();
	}


	public User(Long idUser, String nom, String prenom, String adresse, String rue, int cp, String ville, String pays,
			String tel_Mob, String tel_Fixe, String email_perso, String email_pro, String fonction, String commentaire,
			String particulier_professionnel, Company societe, Set<Inscription> inscriptions) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
		this.tel_Mob = tel_Mob;
		this.tel_Fixe = tel_Fixe;
		this.email_perso = email_perso;
		this.email_pro = email_pro;
		this.fonction = fonction;
		this.commentaire = commentaire;
		this.particulier_professionnel = particulier_professionnel;
		this.societe = societe;
		this.inscriptions = inscriptions;
	}


	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}
	
	@JsonIgnore
	public String getVille() {
		return ville;
	}
	@JsonProperty()
	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTel_Mob() {
		return tel_Mob;
	}

	public void setTel_Mob(String tel_Mob) {
		this.tel_Mob = tel_Mob;
	}

	public String getTel_Fixe() {
		return tel_Fixe;
	}

	public void setTel_Fixe(String tel_Fixe) {
		this.tel_Fixe = tel_Fixe;
	}

	public String getEmail_perso() {
		return email_perso;
	}

	public void setEmail_perso(String email_perso) {
		this.email_perso = email_perso;
	}

	public String getEmail_pro() {
		return email_pro;
	}

	public void setEmail_pro(String email_pro) {
		this.email_pro = email_pro;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getParticulier_professionnel() {
		return particulier_professionnel;
	}

	public void setParticulier_professionnel(String particulier_professionnel) {
		this.particulier_professionnel = particulier_professionnel;
	}



	public Company getSociete() {
		return societe;
	}



	public void setSociete(Company societe) {
		this.societe = societe;
	}



	public Set<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}



	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", rue="
				+ rue + ", cp=" + cp + ", ville=" + ville + ", pays=" + pays + ", tel_Mob=" + tel_Mob + ", tel_Fixe="
				+ tel_Fixe + ", email_perso=" + email_perso + ", email_pro=" + email_pro + ", fonction=" + fonction
				+ ", commentaire=" + commentaire + ", particulier_professionnel=" + particulier_professionnel
				+ ", societe=" + societe + ", inscriptions=" + inscriptions + "]";
	}





}
