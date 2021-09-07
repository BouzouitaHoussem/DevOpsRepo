package com.cataloguetheway.center.config.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Meeting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMeeting;
	private String label;
	private Date jour;
	private Date heure_debt;
	private Date heure_fin;
	private int salle;
	private String lien;
	private String statut;
    
    @ManyToOne
	private Session meetingsession;
    

    
	public Meeting() {
		super();
	}


	public Meeting(Long idMeeting, String label, Date jour, Date heure_debt, Date heure_fin, int salle, String lien,
			String statut, Session meetingsession) {
		super();
		this.idMeeting = idMeeting;
		this.label = label;
		this.jour = jour;
		this.heure_debt = heure_debt;
		this.heure_fin = heure_fin;
		this.salle = salle;
		this.lien = lien;
		this.statut = statut;
		this.meetingsession = meetingsession;
	}





	public String getLien() {
		return lien;
	}





	public void setLien(String lien) {
		this.lien = lien;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}


	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}


	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public Session getMeetingsession() {
		return meetingsession;
	}

	public void setMeetingsession(Session meetingsession) {
		this.meetingsession = meetingsession;
	}


	public Long getIdMeeting() {
		return idMeeting;
	}

	public void setIdMeeting(Long idMeeting) {
		this.idMeeting = idMeeting;
	}

	public Date getJour() {
		return jour;
	}

	public void setJour(Date jour) {
		this.jour = jour;
	}
	
	@Temporal(TemporalType.TIME)
	@Column(name="heure_debt" , nullable =false)
	public Date getHeure_debt() {
		return heure_debt;
	}

	public void setHeure_debt(Date heure_debt) {
		this.heure_debt = heure_debt;
	}
	
	@Temporal(TemporalType.TIME)
	@Column(name="heure_fin" , nullable =false)
	public Date getHeure_fin() {
		return heure_fin;
	}

	public void setHeure_fin(Date heure_fin) {
		this.heure_fin = heure_fin;
	}


	@Override
	public String toString() {
		return "Meeting [idMeeting=" + idMeeting + ", label=" + label + ", jour=" + jour + ", heure_debt=" + heure_debt
				+ ", heure_fin=" + heure_fin + ", salle=" + salle + ", lien=" + lien + ", statut=" + statut
				+ ", meetingsession=" + meetingsession + "]";
	}



	
}
