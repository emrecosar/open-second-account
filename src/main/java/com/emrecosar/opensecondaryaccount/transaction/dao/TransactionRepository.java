package com.emrecosar.opensecondaryaccount.transaction.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.emrecosar.opensecondaryaccount.transaction.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	List<Transaction> findByFromCustomer(Long customerId);

}