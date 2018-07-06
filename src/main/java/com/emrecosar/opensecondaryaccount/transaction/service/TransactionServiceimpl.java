package com.emrecosar.opensecondaryaccount.transaction.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecosar.opensecondaryaccount.transaction.dao.TransactionRepository;
import com.emrecosar.opensecondaryaccount.transaction.model.Transaction;

@Service
public class TransactionServiceimpl implements TransactionService{

	TransactionRepository repo;
	
	@Autowired
	public TransactionServiceimpl(TransactionRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Transaction> getTransactions(Long customerId) {
		return repo.findByFromCustomer(customerId);
	}

	@Override
	public Transaction createTransaction(Long fromCustomer, Long fromAccount, Long toAccount, BigDecimal initialCredit) {
		return repo.save(new Transaction(fromCustomer, fromAccount, toAccount, initialCredit));
	}

}
