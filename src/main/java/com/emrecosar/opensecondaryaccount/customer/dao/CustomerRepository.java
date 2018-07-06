package com.emrecosar.opensecondaryaccount.customer.dao;

import org.springframework.data.repository.CrudRepository;

import com.emrecosar.opensecondaryaccount.customer.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}