package com.backbase.techtest.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {

	private String id;
    private Holder[] holders;
    private Holder holder;
    @JsonProperty("swift_bic")
    private String swiftBic;
    private Bank bank;
    private String number;
    @JsonProperty("IBAN")
    private String iban;
    private String kind;
    private AccountMetadata metadata;
    
	public AccountMetadata getMetadata() {
		return metadata;
	}
	public void setMetadata(AccountMetadata metadata) {
		this.metadata = metadata;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Holder[] getHolders() {
		return holders;
	}
	public void setHolders(Holder[] holders) {
		this.holders = holders;
	}
	public Holder getHolder() {
		return holder;
	}
	public void setHolder(Holder holder) {
		this.holder = holder;
	}
	public String getSwiftBic() {
		return swiftBic;
	}
	public void setSwiftBic(String swiftBic) {
		this.swiftBic = swiftBic;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
}
