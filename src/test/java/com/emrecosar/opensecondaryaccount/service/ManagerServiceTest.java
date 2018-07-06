package com.emrecosar.opensecondaryaccount.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.emrecosar.opensecondaryaccount.account.service.AccountService;
import com.emrecosar.opensecondaryaccount.customer.model.Customer;
import com.emrecosar.opensecondaryaccount.customer.service.CustomerService;
import com.emrecosar.opensecondaryaccount.mapper.CommonMapper;
import com.emrecosar.opensecondaryaccount.transaction.service.TransactionService;

public class ManagerServiceTest {

	AccountService accountService;

	TransactionService transactionService;

	CustomerService customerService;

	CommonMapper mapper = CommonMapper.INSTANCE;
	
	ManagerServiceImpl managerService;
	
	@Before
	public void setup() {
		accountService = mock(AccountService.class);
		transactionService = mock(TransactionService.class);
		customerService = mock(CustomerService.class);
		
		managerService = new ManagerServiceImpl(accountService, transactionService, customerService);
	}
	
	@Test
	public void givenCustomerId_whenNotFound_returnNull(){
		
		Long customerId = 1L;
		Boolean expected = false;
		
		Optional<Customer> actual = managerService.getCustomer(customerId);
		
		assertEquals(expected, actual.isPresent());
	}
	
	
}
