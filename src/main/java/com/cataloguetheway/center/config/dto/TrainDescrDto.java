package com.cataloguetheway.center.config.dto;

import lombok.Value;

import java.util.Date;

@Value
public class TrainDescrDto {

    private Integer id;
    private String titre;
    private String theme;
    private String categorie;
    private Date datelancement;
    private Integer duree;
    private String pays;
    private String region;
    private String image_Name;
    private byte[] image;
    private String status;
    private Integer creditpnt ;
    private Integer price ;
    private String description;
    
	public TrainDescrDto(Integer id, String titre, String theme, String categorie, Date datelancement, Integer duree,
			String pays, String region, String image_Name, byte[] image, String status, Integer creditpnt,
			Integer price, String description) {
		super();
		this.id = id;
		this.titre = titre;
		this.theme = theme;
		this.categorie = categorie;
		this.datelancement = datelancement;
		this.duree = duree;
		this.pays = pays;
		this.region = region;
		this.image_Name = image_Name;
		this.image = image;
		this.status = status;
		this.creditpnt = creditpnt;
		this.price = price;
		this.description = description;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getImage_Name() {
		return image_Name;
	}

	public void setImage_Name(String image_Name) {
		this.image_Name = image_Name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
