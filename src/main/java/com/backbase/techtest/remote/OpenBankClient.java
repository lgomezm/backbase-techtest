package com.backbase.techtest.remote;

import java.util.List;

import org.springframework.stereotype.Component;

import com.backbase.techtest.remote.model.OpenBankTransaction;
import com.backbase.techtest.remote.model.TransactionListResponse;

import retrofit2.Call;
import retrofit2.Response;

@Component
public class OpenBankClient {
	
	private OpenBank openBank;
	
	public OpenBankClient() {
		openBank = OpenBank.createClient();
	}

	public List<OpenBankTransaction> getTransactions(String bankId, String accountId) throws Exception {
		Call<TransactionListResponse> call = openBank.getTransactions(bankId, accountId);
		Response<TransactionListResponse> response = call.execute();
        if (response.isSuccessful()) {
            return response.body().getTransactions();
        } else {
            throw new Exception("Could not get transaction list");
        }
	}

}
