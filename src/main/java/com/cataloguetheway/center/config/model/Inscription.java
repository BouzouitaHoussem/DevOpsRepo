package com.cataloguetheway.center.config.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Inscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sessionsub;
	private int  avance;
	private int montantGlobal;
	
	@ManyToOne
	private User participant;
	
    @ManyToOne
    private  Session session;
	
  
    @JsonIgnore
	@OneToMany(mappedBy = "inscription")
	private Set<RegulatoryTranches> tranchesRegls;

	
	
	public Inscription() {
		super();
	}

	public Inscription(Long id_sessionsub, int avance, int montantGlobal, User participant, Session session,
			Set<RegulatoryTranches> tranchesRegls) {
		super();
		this.id_sessionsub = id_sessionsub;
		this.avance = avance;
		this.montantGlobal = montantGlobal;
		this.participant = participant;
		this.session = session;
		this.tranchesRegls = tranchesRegls;
	}

	public Long getId_sessionsub() {
		return id_sessionsub;
	}
	
	public void setId_sessionsub(Long id_sessionsub) {
		this.id_sessionsub = id_sessionsub;
	}

	public int getAvance() {
		return avance;
	}

	public void setAvance(int avance) {
		this.avance = avance;
	}

	public int getMontantGlobal() {
		return montantGlobal;
	}

	public void setMontantGlobal(int montantGlobal) {
		this.montantGlobal = montantGlobal;
	}

	public User getParticipant() {
		return participant;
	}

	public void setParticipant(User participant) {
		this.participant = participant;
	}


	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Set<RegulatoryTranches> getTranchesRegls() {
		return tranchesRegls;
	}

	public void setTranchesRegls(Set<RegulatoryTranches> tranchesRegls) {
		this.tranchesRegls = tranchesRegls;
	}

	@Override
	public String toString() {
		return "Inscription [id_sessionsub=" + id_sessionsub + ", avance=" + avance + ", montantGlobal=" + montantGlobal
				+ ", participant=" + participant + ", session=" + session + ", tranchesRegls=" + tranchesRegls + "]";
	}
	
}
