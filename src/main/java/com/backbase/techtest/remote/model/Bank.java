package com.backbase.techtest.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bank {

	@JsonProperty("national_identifier")
	private String nationalIdentifier;
	private String name;
	
	public String getNationalIdentifier() {
		return nationalIdentifier;
	}
	public void setNationalIdentifier(String nationalIdentifier) {
		this.nationalIdentifier = nationalIdentifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
