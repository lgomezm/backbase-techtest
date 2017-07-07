package com.backbase.techtest.converter;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.backbase.techtest.dto.Transaction;
import com.backbase.techtest.remote.model.Account;
import com.backbase.techtest.remote.model.AccountMetadata;
import com.backbase.techtest.remote.model.Balance;
import com.backbase.techtest.remote.model.Detail;
import com.backbase.techtest.remote.model.Holder;
import com.backbase.techtest.remote.model.OpenBankTransaction;

public class TransactionConverterTest {

	@Test
	public void testConvertTransaction() {
		OpenBankTransaction transaction = new OpenBankTransaction();
		transaction.setDetails(new Detail());
		transaction.getDetails().setValue(new Balance());
		transaction.setOtherAccount(new Account());
		transaction.setThisAccount(new Account());
		transaction.getOtherAccount().setHolder(new Holder());
		transaction.getOtherAccount().setMetadata(new AccountMetadata());
		
		transaction.setId(UUID.randomUUID());
		transaction.getThisAccount().setId("savings-kids-john");
		transaction.getOtherAccount().setNumber("13677980653");
		transaction.getOtherAccount().getHolder().setName("ALIAS_CBCDE5");
		transaction.getOtherAccount().getMetadata().setImageURL("http://localhost/logo.png");
		transaction.getDetails().getValue().setAmount(10.0);
		transaction.getDetails().getValue().setCurrency("GBP");
		transaction.getDetails().setType("sandbox-payment");
		transaction.getDetails().setDescription("Description abc");
		
		Transaction converted = TransactionConverter.fromOpenBankTransaction(transaction);
		
		assertEquals("Transaction ids don't match", transaction.getId().toString(), converted.getId());
		assertEquals("Account ids don't match", transaction.getThisAccount().getId(), converted.getAccountId());
		assertEquals("Counterparty account numbers don't match", transaction.getOtherAccount().getNumber(), converted.getCounterpartyAccount());
		assertEquals("Counterparty names don't match", transaction.getOtherAccount().getHolder().getName(), converted.getCounterpartyName());
		assertEquals("Counterparty logo paths don't match", transaction.getOtherAccount().getMetadata().getImageURL(), converted.getCounterPartyLogoPath());
		assertEquals("Instructed amounts don't match", transaction.getDetails().getValue().getAmount(), converted.getInstructedAmount(), 0.0000001);
		assertEquals("Instructed currencies don't match", transaction.getDetails().getValue().getCurrency(), converted.getInstructedCurrency());
		assertEquals("Transaction amounts don't match", transaction.getDetails().getValue().getAmount(), converted.getTransactionAmount(), 0.0000001);
		assertEquals("Transaction types don't match", transaction.getDetails().getType(), converted.getTransactionType());
		assertEquals("Transaction descriptions don't match", transaction.getDetails().getDescription(), converted.getDescription());
	}
}
