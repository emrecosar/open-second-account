package com.emrecosar.opensecondaryaccount.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emrecosar.opensecondaryaccount.account.model.Account;
import com.emrecosar.opensecondaryaccount.account.service.AccountService;
import com.emrecosar.opensecondaryaccount.transaction.model.Transaction;
import com.emrecosar.opensecondaryaccount.transaction.service.TransactionService;
import com.emrecosar.opensecondaryaccount.user.model.Customer;
import com.emrecosar.opensecondaryaccount.user.service.CustomerService;
import com.emrecosar.opensecondaryaccount.web.model.CustomerEnrichedDataModel;

@RestController
@RequestMapping
public class ManagerController {

	CustomerService customerService;

	TransactionService transactionService;

	AccountService accountService;

	@Autowired
	public ManagerController(CustomerService customerService, TransactionService transactionService,
			AccountService accountService) {
		this.customerService = customerService;
		this.transactionService = transactionService;
		this.accountService = accountService;
	}

	@PostMapping(value = "/account")
	public ResponseEntity<?> openSecondaryAccount(
			@RequestParam(value = "customer id", required = true) Long customerId,
			@RequestParam(value = "initial credit", required = true) BigDecimal initialCredit)
			throws IOException {

		Account secondaryAccount = null; 
		Optional<Customer> customerOptional = customerService.findUser(customerId);

		if (customerOptional.isPresent()) {
			Customer customer = customerOptional.get();

			List<Account> accounts = accountService.getAccountsForCustomer(customer.getId());
			if (CollectionUtils.isEmpty(accounts)) {
				return new ResponseEntity<String>("Customer does not have any account!", HttpStatus.NOT_FOUND);
			}

			if (accounts.size() > 1) {
				return new ResponseEntity<String>("Customer has already two accounts!",
						HttpStatus.CONFLICT);
			}

			Account account = accounts.get(0);

			secondaryAccount = accountService.createAccountForCustomer(customerId, initialCredit);

			if (initialCredit.compareTo(BigDecimal.ZERO) > 0 && account.getBalance().compareTo(initialCredit) > 0) {
				accountService.updateAccountForCustomer(account.getId(), account.getBalance().subtract(initialCredit));
				transactionService.createTransaction(customer.getId(), account.getId(), secondaryAccount.getId(), initialCredit);
			}

		} else {
			return new ResponseEntity<String>("Customer not found!",
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Account>(secondaryAccount, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/customer/{customerId}")
	public ResponseEntity<?> getCustomerInformation(
			@PathVariable(value = "customerId", required = true) Long customerId)
			throws IOException {
		
		CustomerEnrichedDataModel response = new CustomerEnrichedDataModel();
		
		Optional<Customer> customerOptional = customerService.findUser(customerId);
		if (customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			
			response.setName(customer.getName());
			response.setSurname(customer.getSurname());
			
			List<Account> accounts = accountService.getAccountsForCustomer(customer.getId());
			BigDecimal totalBalance = BigDecimal.ZERO;
			for(Account account : accounts) {
				totalBalance = totalBalance.add(account.getBalance());
				
			}
			
			response.setTotalBalance(totalBalance);
			
			List<Transaction> transactions = transactionService.getTransactions(customer.getId());
			
			response.setTransactions(transactions);
			
		} else {
			return new ResponseEntity<String>("Customer not found!",
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<CustomerEnrichedDataModel>(response, HttpStatus.CREATED);
	}


}
