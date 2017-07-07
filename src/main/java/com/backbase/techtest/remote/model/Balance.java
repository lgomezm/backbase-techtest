package com.backbase.techtest.remote.model;

public class Balance {

	private Double amount;
    private String currency;

    public Double getAmount () {
        return amount;
    }

    public void setAmount (Double amount) {
        this.amount = amount;
    }

    public String getCurrency () {
        return currency;
    }

    public void setCurrency (String currency) {
        this.currency = currency;
    }
}
