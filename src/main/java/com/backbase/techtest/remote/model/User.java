package com.backbase.techtest.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	private String id;
	private String provider;
	@JsonProperty("display_name")
	private String displayName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
