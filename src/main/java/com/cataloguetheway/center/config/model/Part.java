package com.cataloguetheway.center.config.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Part")
@Data
public class Part {

    @Id
    @GeneratedValue
    private Integer Id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "chapiter_id",referencedColumnName = "id")
    private List<Section> sections = new ArrayList<>();
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

    
}
