package com.cataloguetheway.center.config.website.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cataloguetheway.center.config.website.util.RoleNumber;
import com.sun.istack.NotNull;




@Entity
public class Role {
	   @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	    @Enumerated(EnumType.STRING)
	    @NotNull    
	    private RoleNumber roleNumber;
	    
	    public Role() {
	    }

	    public Role(RoleNumber roleNumber) {
	        this.roleNumber = roleNumber;
	    }

	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public RoleNumber getRoleNumber() {
			return roleNumber;
		}
		public void setRoleNumber(RoleNumber roleNumber) {
			this.roleNumber = roleNumber;
		}
	
	
	
}
