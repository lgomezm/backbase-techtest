package com.backbase.techtest.remote;

import java.util.List;

import com.backbase.techtest.remote.model.Transaction;
import com.backbase.techtest.remote.model.TransactionListResponse;

import retrofit2.Call;
import retrofit2.Response;

public class OpenBankClient {
	
	private OpenBank openBank;
	
	public OpenBankClient() {
		openBank = OpenBank.createClient();
	}

	public List<Transaction> getTransactions(String bankId, String accountId) throws Exception {
		Call<TransactionListResponse> call = openBank.getTransactions(bankId, accountId);
		Response<TransactionListResponse> response = call.execute();
        if (response.isSuccessful()) {
            return response.body().getTransactions();
        } else {
            throw new Exception("Could not get transaction list");
        }
	}

}
