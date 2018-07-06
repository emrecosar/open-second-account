package com.emrecosar.opensecondaryaccount.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.emrecosar.opensecondaryaccount.account.model.Account;
import com.emrecosar.opensecondaryaccount.account.service.AccountService;
import com.emrecosar.opensecondaryaccount.customer.model.Customer;
import com.emrecosar.opensecondaryaccount.customer.service.CustomerService;
import com.emrecosar.opensecondaryaccount.mapper.CommonMapper;
import com.emrecosar.opensecondaryaccount.transaction.model.Transaction;
import com.emrecosar.opensecondaryaccount.transaction.service.TransactionService;
import com.emrecosar.opensecondaryaccount.web.model.AccountModel;
import com.emrecosar.opensecondaryaccount.web.model.CustomerEnrichedDataModel;

@Service
public class ManagerServiceImpl implements ManagerService {

	AccountService accountService;

	TransactionService transactionService;

	CustomerService customerService;

	CommonMapper mapper = CommonMapper.INSTANCE;

	@Autowired
	public ManagerServiceImpl(AccountService accountService, TransactionService transactionService,
			CustomerService customerService) {
		this.accountService = accountService;
		this.transactionService = transactionService;
		this.customerService = customerService;
	}

	@Override
	public Optional<Customer> getCustomer(Long customerId) {

		return customerService.findCustomer(customerId);
	
	}

	@Override
	public AccountModel createSecondaryAccount(Customer customer, BigDecimal initialCredit) {

		List<Account> accounts = accountService.getAccountsForCustomer(customer.getId());
		if (!CollectionUtils.isEmpty(accounts)) {
			Account secondaryAccount = accountService.createAccountForCustomer(customer.getId());
			if (initialCredit.compareTo(BigDecimal.ZERO) > 0) {
				transactionService.createTransaction(customer.getId(), null, secondaryAccount.getId(), initialCredit);
			}
			return mapper.toAccountModel(secondaryAccount);
		}

		return null;
	}

	@Override
	public CustomerEnrichedDataModel aggregateCustomerData(Customer customer) {

		CustomerEnrichedDataModel response = new CustomerEnrichedDataModel();

		response.setName(customer.getName());
		response.setSurname(customer.getSurname());

		List<Account> accounts = accountService.getAccountsForCustomer(customer.getId());
		BigDecimal totalBalance = BigDecimal.ZERO;
		for (Account account : accounts) {
			totalBalance = totalBalance.add(account.getBalance());

		}

		response.setTotalBalance(totalBalance);

		List<Transaction> transactions = transactionService.getTransactions(customer.getId());

		response.setTransactions(mapper.toTransactionsModel(transactions));

		return response;
	}

}
