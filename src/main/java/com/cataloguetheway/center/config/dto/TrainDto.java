package com.cataloguetheway.center.config.dto;

import lombok.Value;

import java.util.Date;

@Value
public class TrainDto {

    private Integer id;
    private String titre;
    private String theme;
    private String categorie;
    private Date datelancement;
    private Integer duree;
    private String pays;
    private Integer idpays;
    private String region;
    private String imageName;
    private byte[] image;
    private String status;
    private Integer creditpnt ;
    private Integer price ; 
    
    
	public TrainDto(Integer id, String titre, String theme, String categorie, Date datelancement, Integer duree,
			String pays, Integer idpays, String region, String imageName, byte[] image, String status,
			Integer creditpnt, Integer price) {
		super();
		this.id = id;
		this.titre = titre;
		this.theme = theme;
		this.categorie = categorie;
		this.datelancement = datelancement;
		this.duree = duree;
		this.pays = pays;
		this.idpays = idpays;
		this.region = region;
		this.imageName = imageName;
		this.image = image;
		this.status = status;
		this.creditpnt = creditpnt;
		this.price = price;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getTheme() {
		return theme;
	}


	public void setTheme(String theme) {
		this.theme = theme;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public Date getDatelancement() {
		return datelancement;
	}


	public void setDatelancement(Date datelancement) {
		this.datelancement = datelancement;
	}


	public Integer getDuree() {
		return duree;
	}


	public void setDuree(Integer duree) {
		this.duree = duree;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	public Integer getIdpays() {
		return idpays;
	}


	public void setIdpays(Integer idpays) {
		this.idpays = idpays;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getCreditpnt() {
		return creditpnt;
	}


	public void setCreditpnt(Integer creditpnt) {
		this.creditpnt = creditpnt;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}

	
	
	
}
