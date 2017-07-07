package com.backbase.techtest.remote.model;

import java.util.List;

public class TransactionMetadata {

	private String narrative;
	private List<Tag> tags;
	private List<Comment> comments;
	private List<Image> images;
	private Location where;
	
	public String getNarrative() {
		return narrative;
	}
	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public Location getWhere() {
		return where;
	}
	public void setWhere(Location where) {
		this.where = where;
	}
}
