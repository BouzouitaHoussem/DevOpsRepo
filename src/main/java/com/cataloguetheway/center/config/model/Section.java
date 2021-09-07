package com.cataloguetheway.center.config.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="Section")
public class Section {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
}
