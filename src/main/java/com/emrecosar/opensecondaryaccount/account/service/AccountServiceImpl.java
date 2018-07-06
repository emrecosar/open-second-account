package com.emrecosar.opensecondaryaccount.account.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecosar.opensecondaryaccount.account.dao.AccountRepository;
import com.emrecosar.opensecondaryaccount.account.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	AccountRepository repo;

	@Autowired
	public AccountServiceImpl(AccountRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Account> getAccountsForCustomer(Long customerId) {
		return repo.findAllTransactionsByCustomerId(customerId);
	}

	@Override
	public Account createAccountForCustomer(Long customerId) {
		return repo.save(new Account(customerId, BigDecimal.ZERO));
	}

	@Override
	public Account updateAccountForCustomer(Long accountId, BigDecimal newBalance) {
		Optional<Account> accountOptinal = repo.findById(accountId);
		if(accountOptinal.isPresent()) {
			Account account = accountOptinal.get();
			account.setBalance(newBalance);
			return repo.save(account);
		}
		return null;
		
	}

}
