package com.backbase.techtest.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {

	private String id;
	private String label;
	@JsonProperty("URL")
	private String url;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
