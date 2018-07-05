package com.emrecosar.opensecondaryaccount.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrecosar.opensecondaryaccount.user.dao.CustomerRepository;
import com.emrecosar.opensecondaryaccount.user.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	CustomerRepository repo;
	
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository repo) {
		this.repo = repo;
	}

	@Override
	public Optional<Customer> findUser(Long customerId) {
		return repo.findById(customerId);
	}

}
