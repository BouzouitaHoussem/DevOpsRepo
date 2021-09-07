package com.cataloguetheway.center.config.model;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table (name = "Category")
@Data
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    private String theme;
    @NotBlank
    private String label;
    @Column(columnDefinition = "TEXT")
    @NotBlank
    private String shortdesc;
    @Column(columnDefinition = "TEXT")
    private String longdesc;
    private String userAdd;
    private LocalDate addDate;
    private boolean active;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getShortdesc() {
		return shortdesc;
	}
	public void setShortdesc(String shortdesc) {
		this.shortdesc = shortdesc;
	}
	public String getLongdesc() {
		return longdesc;
	}
	public void setLongdesc(String longdesc) {
		this.longdesc = longdesc;
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

    
}