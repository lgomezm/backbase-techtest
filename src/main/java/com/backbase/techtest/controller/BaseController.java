package com.backbase.techtest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backbase.techtest.converter.TransactionConverter;
import com.backbase.techtest.dto.Transaction;
import com.backbase.techtest.remote.OpenBankClient;
import com.backbase.techtest.remote.model.OpenBankTransaction;


@Controller
public class BaseController {

	private final static Logger LOG = LoggerFactory.getLogger(BaseController.class);
	
	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public @ResponseBody List<Transaction> getTransactions() {
		LOG.info("Start getDummyEmployee");
		OpenBankClient client = new OpenBankClient();
		try {
			List<OpenBankTransaction> openBankTransactions = client.getTransactions("rbs", "savings-kids-john");
			return openBankTransactions.stream()
					.map(TransactionConverter::fromOpenBankTransaction)
					.collect(Collectors.toList());
		} catch (Exception e) {
			LOG.error("Error getting transactions", e);
			return null;
		}
	}
}
