package com.emrecosar.opensecondaryaccount.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecosar.opensecondaryaccount.customer.dao.CustomerRepository;
import com.emrecosar.opensecondaryaccount.customer.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	CustomerRepository repo;
	
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository repo) {
		this.repo = repo;
	}

	@Override
	public Optional<Customer> findCustomer(Long customerId) {
		return repo.findById(customerId);
	}

}
