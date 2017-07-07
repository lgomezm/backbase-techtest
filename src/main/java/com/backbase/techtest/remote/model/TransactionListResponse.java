package com.backbase.techtest.remote.model;

import java.util.List;

public class TransactionListResponse {

	private List<Transaction> transactions;

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}
