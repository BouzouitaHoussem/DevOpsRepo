package com.cataloguetheway.center.config.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Themes")
@Data
public class Themes {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    private String label;
    private String userAdd;
    private LocalDate addDate;
    private boolean active;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "them_id",referencedColumnName = "id")
    private List<Category> categoriesListe;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getUserAdd() {
		return userAdd;
	}
	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}
	public LocalDate getAddDate() {
		return addDate;
	}
	public void setAddDate(LocalDate addDate) {
		this.addDate = addDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public List<Category> getCategoriesListe() {
		return categoriesListe;
	}
	public void setCategoriesListe(List<Category> categoriesListe) {
		this.categoriesListe = categoriesListe;
	}

    
    
}