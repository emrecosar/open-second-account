package com.emrecosar.opensecondaryaccount.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.emrecosar.opensecondaryaccount.user.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}