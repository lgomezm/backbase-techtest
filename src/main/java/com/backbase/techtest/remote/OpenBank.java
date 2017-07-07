package com.backbase.techtest.remote;

import com.backbase.techtest.remote.model.TransactionListResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OpenBank {

	@GET("banks/{bank_id}/accounts/{account_id}/public/transactions")
	Call<TransactionListResponse> getTransactions(@Path("bank_id") String bankId, @Path("account_id") String accountId);
	
	static OpenBank createClient() {
		Retrofit retrofit = new Retrofit.Builder()
	                .baseUrl("https://apisandbox.openbankproject.com/obp/v1.2.1/")
	                .addConverterFactory(JacksonConverterFactory.create())
	                .build();
		return retrofit.create(OpenBank.class);
	}
}
