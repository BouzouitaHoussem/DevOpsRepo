package com.cataloguetheway.center.config.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="Training")
@Data
public class Training {

    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    private String titre;
    private String theme;
    private String categorie;
    @Temporal(TemporalType.DATE)
    @Column(name="datelancement")
    private Date datelancement;
    private Integer duree;
    @Column(columnDefinition = "TEXT")
    private String  description;

    private String  plan_name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "train_id",referencedColumnName = "id")
    private List<Part> plan = new ArrayList<Part>();

    @Column(columnDefinition = "TEXT")
    private String progText;
    private byte[] progPJ ;
    private String progName;
    private String pays;
    private Integer idpays;
    private String region;
    private String idfrond;
    private String advertise;
    @Column(columnDefinition = "TEXT")
    private String prerequise;
    private String imageName;
    private String certeficat;
    private byte[] image;
    private String status;
    private Integer creditpnt ;
    private Integer price ;
    
    
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public List<Part> getPlan() {
		return plan;
	}
	public void setPlan(List<Part> plan) {
		this.plan = plan;
	}
	public String getProgText() {
		return progText;
	}
	public void setProgText(String progText) {
		this.progText = progText;
	}
	public byte[] getProgPJ() {
		return progPJ;
	}
	public void setProgPJ(byte[] progPJ) {
		this.progPJ = progPJ;
	}
	public String getProgName() {
		return progName;
	}
	public void setProgName(String progName) {
		this.progName = progName;
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
	public String getIdfrond() {
		return idfrond;
	}
	public void setIdfrond(String idfrond) {
		this.idfrond = idfrond;
	}
	public String getAdvertise() {
		return advertise;
	}
	public void setAdvertise(String advertise) {
		this.advertise = advertise;
	}
	public String getPrerequise() {
		return prerequise;
	}
	public void setPrerequise(String prerequise) {
		this.prerequise = prerequise;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getCerteficat() {
		return certeficat;
	}
	public void setCerteficat(String certeficat) {
		this.certeficat = certeficat;
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
