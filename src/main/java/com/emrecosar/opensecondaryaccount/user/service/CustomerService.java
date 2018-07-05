package com.emrecosar.opensecondaryaccount.user.service;

import java.util.Optional;

import com.emrecosar.opensecondaryaccount.user.model.Customer;

public interface CustomerService {

	Optional<Customer> findUser(Long customerId);

}
