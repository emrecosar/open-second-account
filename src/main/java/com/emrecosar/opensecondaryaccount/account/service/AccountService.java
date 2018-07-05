package com.emrecosar.opensecondaryaccount.account.service;

import java.math.BigDecimal;
import java.util.List;

import com.emrecosar.opensecondaryaccount.account.model.Account;

public interface AccountService {

	List<Account>getAccountsForCustomer(Long customerId);

	Account createAccountForCustomer(Long customerId, BigDecimal amount);
	
	Account updateAccountForCustomer(Long accountId, BigDecimal newBalance);
}
