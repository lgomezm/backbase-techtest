package com.backbase.techtest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backbase.techtest.converter.TransactionConverter;
import com.backbase.techtest.dto.TotalAmount;
import com.backbase.techtest.dto.Transaction;
import com.backbase.techtest.remote.OpenBankClient;
import com.backbase.techtest.remote.model.OpenBankTransaction;

@Controller
public class BaseController {

	private final static Logger LOG = LoggerFactory.getLogger(BaseController.class);
	
	private static final String BANK_ID = "rbs";
	private static final String ACCOUNT_ID = "savings-kids-john";
	
	@Autowired
	private OpenBankClient client;
	
	public void setOpenBankClient(OpenBankClient client) {
		this.client = client;
	}
	
	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public @ResponseBody List<Transaction> getTransactions() {
		LOG.debug("Start getTransactions");
		try {
			List<OpenBankTransaction> openBankTransactions = client.getTransactions(BANK_ID, ACCOUNT_ID);
			LOG.debug("Got {} transactions", openBankTransactions.size());
			return openBankTransactions.stream()
					.map(TransactionConverter::fromOpenBankTransaction)
					.collect(Collectors.toList());
		} catch (Exception e) {
			LOG.error("Error getting transactions", e);
			return null;
		}
	}
	
	@RequestMapping(value = "/transactions/{type}", method = RequestMethod.GET)
	public @ResponseBody List<Transaction> getTransactionsByType(@PathVariable("type") String transactionType) {
		LOG.debug("Start getTransactionsByType");
		try {
			List<OpenBankTransaction> openBankTransactions = client.getTransactions(BANK_ID, ACCOUNT_ID);
			LOG.debug("Got {} transactions", openBankTransactions.size());
			return openBankTransactions.stream()
					.filter(t -> null != t.getDetails() && transactionType.equals(t.getDetails().getType()))
					.map(TransactionConverter::fromOpenBankTransaction)
					.collect(Collectors.toList());
		} catch (Exception e) {
			LOG.error("Error getting transactions", e);
			return null;
		}
	}
	
	@RequestMapping(value = "/transactions/{type}/amount", method = RequestMethod.GET)
	public @ResponseBody TotalAmount getTotalAmountForTransactionType(@PathVariable("type") String transactionType) {
		LOG.debug("Start getTotalAmountForTransactionType");
		try {
			List<OpenBankTransaction> openBankTransactions = client.getTransactions(BANK_ID, ACCOUNT_ID);
			LOG.debug("Got {} transactions", openBankTransactions.size());
			double total = openBankTransactions.stream()
					.filter(t -> null != t.getDetails() && transactionType.equals(t.getDetails().getType()))
					.map(TransactionConverter::fromOpenBankTransaction)
					.map(Transaction::getTransactionAmount)
					.reduce(0.0, (a1, a2) -> a1 + a2);
			TotalAmount totalAmount = new TotalAmount();
			totalAmount.setAmount(total);
			totalAmount.setTransactionType(transactionType);
			return totalAmount;
		} catch (Exception e) {
			LOG.error("Error getting transactions", e);
			return null;
		}
	}
}
