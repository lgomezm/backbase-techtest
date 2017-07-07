package com.backbase.techtest.remote.model;

import java.util.List;

public class TransactionListResponse {

	private List<OpenBankTransaction> transactions;

	public List<OpenBankTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<OpenBankTransaction> transactions) {
		this.transactions = transactions;
	}
}
