package com.backbase.techtest.remote;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.backbase.techtest.remote.model.OpenBankTransaction;

public class OpenBankClientTest {

	@Test
	public void testClientWorks() {
		OpenBankClient client = new OpenBankClient();
		try {
			List<OpenBankTransaction> transactions = client.getTransactions("rbs", "savings-kids-john");
			assertFalse("Transaction list is null", transactions.isEmpty());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
