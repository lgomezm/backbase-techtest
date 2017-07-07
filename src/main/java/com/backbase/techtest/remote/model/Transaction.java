package com.backbase.techtest.remote.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {

	private UUID id;
    private Detail details;
    @JsonProperty("other_account")
    private Account otherAccount;
    @JsonProperty("this_account")
    private Account thisAccount;
    private TransactionMetadata metadata;
    
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Detail getDetails() {
		return details;
	}
	public void setDetails(Detail details) {
		this.details = details;
	}
	public Account getOtherAccount() {
		return otherAccount;
	}
	public void setOtherAccount(Account otherAccount) {
		this.otherAccount = otherAccount;
	}
	public Account getThisAccount() {
		return thisAccount;
	}
	public void setThisAccount(Account thisAccount) {
		this.thisAccount = thisAccount;
	}
	public TransactionMetadata getMetadata() {
		return metadata;
	}
	public void setMetadata(TransactionMetadata metadata) {
		this.metadata = metadata;
	}

}
