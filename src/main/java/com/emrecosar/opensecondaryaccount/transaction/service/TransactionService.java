package com.emrecosar.opensecondaryaccount.transaction.service;

import java.math.BigDecimal;
import java.util.List;

import com.emrecosar.opensecondaryaccount.transaction.model.Transaction;

public interface TransactionService {
	
	List<Transaction> getTransactions(Long customerId);

	Transaction createTransaction(Long fromCustomer, Long fromAccount, Long toAccount, BigDecimal initialCredit); 

}
