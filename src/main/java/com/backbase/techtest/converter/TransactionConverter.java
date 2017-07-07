package com.backbase.techtest.converter;

import java.util.Optional;
import java.util.UUID;

import com.backbase.techtest.dto.Transaction;
import com.backbase.techtest.remote.model.Account;
import com.backbase.techtest.remote.model.AccountMetadata;
import com.backbase.techtest.remote.model.Balance;
import com.backbase.techtest.remote.model.Detail;
import com.backbase.techtest.remote.model.Holder;
import com.backbase.techtest.remote.model.OpenBankTransaction;

public class TransactionConverter {

	public static Transaction fromOpenBankTransaction(OpenBankTransaction transaction) {
		Transaction toReturn = new Transaction();
		Optional<OpenBankTransaction> optTransaction = Optional.ofNullable(transaction);
		Optional<Detail> optDetails = optTransaction.map(OpenBankTransaction::getDetails);
		Optional<Account> optOtherAccount = optTransaction.map(OpenBankTransaction::getOtherAccount);
		
		toReturn.setId(optTransaction.map(OpenBankTransaction::getId).map(UUID::toString).orElse(null));
		toReturn.setAccountId(optTransaction.map(OpenBankTransaction::getThisAccount).map(Account::getId).orElse(null));
		toReturn.setCounterpartyAccount(optOtherAccount.map(Account::getNumber).orElse(null));
		toReturn.setCounterpartyName(optOtherAccount.map(Account::getHolder).map(Holder::getName).orElse(null));
		toReturn.setCounterPartyLogoPath(optOtherAccount.map(Account::getMetadata).map(AccountMetadata::getImageURL).orElse(null));
		toReturn.setInstructedAmount(optDetails.map(Detail::getValue).map(Balance::getAmount).orElse(0.0));
		toReturn.setInstructedCurrency(optDetails.map(Detail::getValue).map(Balance::getCurrency).orElse(null));
		toReturn.setTransactionAmount(toReturn.getInstructedAmount());
		toReturn.setTransactionCurrency(toReturn.getInstructedCurrency());
		toReturn.setTransactionType(optDetails.map(Detail::getType).orElse(null));
		toReturn.setDescription(optDetails.map(Detail::getDescription).orElse(null));
		return toReturn;
	}
}
