package com.emrecosar.opensecondaryaccount.account.service;

import java.math.BigDecimal;
import java.util.List;

import com.emrecosar.opensecondaryaccount.account.model.Account;

public interface AccountService {

	List<Account>getAccountsForCustomer(Long customerId);

	Account updateAccountForCustomer(Long accountId, BigDecimal newBalance);

	Account createAccountForCustomer(Long customerId, BigDecimal amount);
}
