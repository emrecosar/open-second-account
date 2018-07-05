package com.emrecosar.opensecondaryaccount;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.emrecosar.opensecondaryaccount.account.dao.AccountRepository;
import com.emrecosar.opensecondaryaccount.account.model.Account;
import com.emrecosar.opensecondaryaccount.user.dao.CustomerRepository;
import com.emrecosar.opensecondaryaccount.user.model.Customer;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepo, AccountRepository accountRepo) {
		return (args) -> {
			// save a couple of customers
			customerRepo.save(new Customer("Jack", "Bauer"));
			customerRepo.save(new Customer("Chloe", "O'Brian"));
			customerRepo.save(new Customer("Kim", "Bauer"));
			customerRepo.save(new Customer("David", "Palmer"));
			customerRepo.save(new Customer("Michelle", "Dessler"));

			// save a couple of accounts belongs to customer
			accountRepo.save(new Account(1L, new BigDecimal(100)));
			accountRepo.save(new Account(2L, new BigDecimal(200)));
			accountRepo.save(new Account(3L, new BigDecimal(300)));
			accountRepo.save(new Account(4L, new BigDecimal(400)));
			accountRepo.save(new Account(5L, new BigDecimal(500)));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : customerRepo.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch all accounts
			log.info("Accounts found with findAll():");
			log.info("-------------------------------");
			for (Account account : accountRepo.findAll()) {
				log.info(account.toString());
			}
			log.info("");
		};
	}
}
