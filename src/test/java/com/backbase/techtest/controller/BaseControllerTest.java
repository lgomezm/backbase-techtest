package com.backbase.techtest.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.backbase.techtest.dto.TotalAmount;
import com.backbase.techtest.dto.Transaction;
import com.backbase.techtest.remote.OpenBankClient;
import com.backbase.techtest.remote.model.Account;
import com.backbase.techtest.remote.model.AccountMetadata;
import com.backbase.techtest.remote.model.Balance;
import com.backbase.techtest.remote.model.Detail;
import com.backbase.techtest.remote.model.Holder;
import com.backbase.techtest.remote.model.OpenBankTransaction;

public class BaseControllerTest {

	@Mock OpenBankClient client;
	
	private BaseController controller;
	private List<OpenBankTransaction> transactionList;
	
	public BaseControllerTest() throws Exception {
		MockitoAnnotations.initMocks(this);
		controller = new BaseController();
		controller.setOpenBankClient(client);
		transactionList = initTransactionList();
		when(client.getTransactions(eq("rbs"), eq("savings-kids-john"))).thenReturn(transactionList);
	}
	
	@Test
	public void testGetTransactions_Success() {
		List<Transaction> transactions = controller.getTransactions();
		assertEquals("Should return 3 transactions", 3, transactions.size());
	}
	
	@Test
	public void testGetTransactions_Fail() throws Exception {
		when(client.getTransactions(eq("rbs"), eq("savings-kids-john"))).thenThrow(new Exception());
		List<Transaction> transactions = controller.getTransactions();
		assertNull("Response should be null", transactions);
	}
	
	@Test
	public void testGetTransactionsByType_Success() {
		List<Transaction> transactions = controller.getTransactionsByType("sandbox-payment");
		assertEquals("Should return 2 transactions", 2, transactions.size());
	}
	
	@Test
	public void testGetTransactionsByType_Fail() throws Exception {
		when(client.getTransactions(eq("rbs"), eq("savings-kids-john"))).thenThrow(new Exception());
		List<Transaction> transactions = controller.getTransactionsByType("sandbox-payment");
		assertNull("Response should be null", transactions);
	}
	
	@Test
	public void testGetTotalAmountForTransactionType_Success() {
		TotalAmount total = controller.getTotalAmountForTransactionType("sandbox-payment");
		assertEquals("Transaction type should be 'sandbox-payment'", "sandbox-payment", total.getTransactionType());
		assertEquals("Total amount should be '30'", 30.0, total.getAmount(), 0.0000001);
	}
	
	@Test
	public void testGetTotalAmountForTransactionType_Fail() throws Exception {
		when(client.getTransactions(eq("rbs"), eq("savings-kids-john"))).thenThrow(new Exception());
		TotalAmount total = controller.getTotalAmountForTransactionType("sandbox-payment");
		assertNull("Response should be null", total);
	}

	private List<OpenBankTransaction> initTransactionList() {
		OpenBankTransaction transaction1 = new OpenBankTransaction();
		transaction1.setDetails(new Detail());
		transaction1.getDetails().setValue(new Balance());
		transaction1.setOtherAccount(new Account());
		transaction1.setThisAccount(new Account());
		transaction1.getOtherAccount().setHolder(new Holder());
		transaction1.getOtherAccount().setMetadata(new AccountMetadata());
		
		transaction1.setId(UUID.randomUUID());
		transaction1.getThisAccount().setId("savings-kids-john");
		transaction1.getOtherAccount().setNumber("13677980653");
		transaction1.getOtherAccount().getHolder().setName("ALIAS_CBCDE5");
		transaction1.getOtherAccount().getMetadata().setImageURL("http://localhost/logo.png");
		transaction1.getDetails().getValue().setAmount(10.0);
		transaction1.getDetails().getValue().setCurrency("GBP");
		transaction1.getDetails().setType("sandbox-payment");
		transaction1.getDetails().setDescription("Description abc");
		
		OpenBankTransaction transaction2 = new OpenBankTransaction();
		transaction2.setDetails(new Detail());
		transaction2.getDetails().setValue(new Balance());
		transaction2.setOtherAccount(new Account());
		transaction2.setThisAccount(new Account());
		transaction2.getOtherAccount().setHolder(new Holder());
		transaction2.getOtherAccount().setMetadata(new AccountMetadata());
		
		transaction2.setId(UUID.randomUUID());
		transaction2.getThisAccount().setId("savings-pandas");
		transaction2.getOtherAccount().setNumber("13677980777");
		transaction2.getOtherAccount().getHolder().setName("ALIAS_PANDAS");
		transaction2.getOtherAccount().getMetadata().setImageURL("http://localhost/pandas.png");
		transaction2.getDetails().getValue().setAmount(15.0);
		transaction2.getDetails().getValue().setCurrency("GBP");
		transaction2.getDetails().setType("important-payment");
		transaction2.getDetails().setDescription("Description def");
		
		OpenBankTransaction transaction3 = new OpenBankTransaction();
		transaction3.setDetails(new Detail());
		transaction3.getDetails().setValue(new Balance());
		transaction3.setOtherAccount(new Account());
		transaction3.setThisAccount(new Account());
		transaction3.getOtherAccount().setHolder(new Holder());
		transaction3.getOtherAccount().setMetadata(new AccountMetadata());
		
		transaction3.setId(UUID.randomUUID());
		transaction3.getThisAccount().setId("savings-kids-john");
		transaction3.getOtherAccount().setNumber("13677980653");
		transaction3.getOtherAccount().getHolder().setName("ALIAS_CBCDE5");
		transaction3.getOtherAccount().getMetadata().setImageURL("http://localhost/logo.png");
		transaction3.getDetails().getValue().setAmount(20.0);
		transaction3.getDetails().getValue().setCurrency("GBP");
		transaction3.getDetails().setType("sandbox-payment");
		transaction3.getDetails().setDescription("Description abc2");
		
		return Arrays.asList(transaction1, transaction2, transaction3);
	}
}
