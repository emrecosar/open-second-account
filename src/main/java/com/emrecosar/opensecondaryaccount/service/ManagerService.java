package com.emrecosar.opensecondaryaccount.service;

import java.math.BigDecimal;
import java.util.Optional;

import com.emrecosar.opensecondaryaccount.customer.model.Customer;
import com.emrecosar.opensecondaryaccount.web.model.AccountModel;
import com.emrecosar.opensecondaryaccount.web.model.CustomerEnrichedDataModel;

public interface ManagerService {

	Optional<Customer> getCustomer(Long customerId);

	CustomerEnrichedDataModel aggregateCustomerData(Customer customerId);

	AccountModel createSecondaryAccount(Customer customerId, BigDecimal initialCredit);

}
