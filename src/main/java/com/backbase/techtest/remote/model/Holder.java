package com.backbase.techtest.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Holder {

	@JsonProperty("is_alias")
	private boolean isAlias;
    private String name;

    public String getName () {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }
	public boolean isAlias() {
		return isAlias;
	}
	public void setAlias(boolean isAlias) {
		this.isAlias = isAlias;
	}
}
