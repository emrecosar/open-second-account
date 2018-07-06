package com.emrecosar.opensecondaryaccount.customer.service;

import java.util.Optional;

import com.emrecosar.opensecondaryaccount.customer.model.Customer;

public interface CustomerService {

	Optional<Customer> findUser(Long customerId);

}
