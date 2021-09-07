package com.cataloguetheway.center.config.dto;

import lombok.Value;

@Value
public class imageDto {

    private String name;
    private byte[] resource;
    
    
	public imageDto(String name, byte[] resource) {
		super();
		this.name = name;
		this.resource = resource;
	}

}
