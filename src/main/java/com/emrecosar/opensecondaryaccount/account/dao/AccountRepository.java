package com.emrecosar.opensecondaryaccount.account.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.emrecosar.opensecondaryaccount.account.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	@Query("Select a from Account a where a.customerId = :customerId")
	List<Account> findAllTransactionsByCustomerId(@Param("customerId") Long customerId);
	
}

