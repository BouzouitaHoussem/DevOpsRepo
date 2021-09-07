package com.cataloguetheway.center.config.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idEntreprise;
	 private String mfrciu;
	 private String nom;
	 private String adresse;
	 private String tel;
	 private String email;
	 private String site;
	 
	 @JsonIgnore
	 @OneToMany(mappedBy = "societe")
	 private Set<User> users;

	 
	public Company() {
		super();
	}



	public Company(Long idEntreprise, String mfrciu, String nom, String adresse, String tel, String email, String site,
			Set<User> users) {
		super();
		this.idEntreprise = idEntreprise;
		this.mfrciu = mfrciu;
		this.nom = nom;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.site = site;
		this.users = users;
	}



	public Long getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(Long idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public String getMfrciu() {
		return mfrciu;
	}

	public void setMfrciu(String mfrciu) {
		this.mfrciu = mfrciu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}



	@Override
	public String toString() {
		return "Business [idEntreprise=" + idEntreprise + ", mfrciu=" + mfrciu + ", nom=" + nom + ", adresse=" + adresse
				+ ", tel=" + tel + ", email=" + email + ", site=" + site + ", users=" + users + "]";
	}

	 
	 
}

