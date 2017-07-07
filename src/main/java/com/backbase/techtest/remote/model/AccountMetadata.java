package com.backbase.techtest.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountMetadata {

	@JsonProperty("physical_location")
	private Location physicalLocation;
	@JsonProperty("open_corporates_URL")
    private String openCorporatesURL;
    private String private_alias;
    @JsonProperty("more_info")
    private String moreInfo;
    @JsonProperty("image_URL")
    private String imageURL;
    @JsonProperty("corporate_location")
    private Location corporateLocation;
    @JsonProperty("URL")
    private String url;
    @JsonProperty("public_alias")
    private String publicAlias;
    
	public Location getPhysicalLocation() {
		return physicalLocation;
	}
	public void setPhysicalLocation(Location physicalLocation) {
		this.physicalLocation = physicalLocation;
	}
	public String getOpenCorporatesURL() {
		return openCorporatesURL;
	}
	public void setOpenCorporatesURL(String openCorporatesURL) {
		this.openCorporatesURL = openCorporatesURL;
	}
	public String getPrivate_alias() {
		return private_alias;
	}
	public void setPrivate_alias(String private_alias) {
		this.private_alias = private_alias;
	}
	public String getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public Location getCorporateLocation() {
		return corporateLocation;
	}
	public void setCorporateLocation(Location corporateLocation) {
		this.corporateLocation = corporateLocation;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPublicAlias() {
		return publicAlias;
	}
	public void setPublicAlias(String publicAlias) {
		this.publicAlias = publicAlias;
	}
}
