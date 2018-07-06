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
import com.emrecosar.opensecondaryaccount.customer.dao.CustomerRepository;
import com.emrecosar.opensecondaryaccount.customer.model.Customer;
import com.emrecosar.opensecondaryaccount.transaction.dao.TransactionRepository;
import com.emrecosar.opensecondaryaccount.transaction.model.Transaction;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepo, AccountRepository accountRepo, TransactionRepository transactionRepo) {
		return (args) -> {

			// save a couple of customers
			Customer c1 = customerRepo.save(new Customer("Jack", "Bauer"));
			Customer c2 = customerRepo.save(new Customer("Julia", "Roberts"));
			Customer c3 = customerRepo.save(new Customer("Kim", "Bassinger"));
			Customer c4 = customerRepo.save(new Customer("David", "Bowie"));
			Customer c5 = customerRepo.save(new Customer("Michael", "Fessbender"));

			// save a couple of accounts belongs to customer
			Account a1 = accountRepo.save(new Account(c1.getId(), new BigDecimal(100)));
			Account a2 = accountRepo.save(new Account(c2.getId(), new BigDecimal(200)));
			Account a3 = accountRepo.save(new Account(c3.getId(), new BigDecimal(300)));
			Account a4 = accountRepo.save(new Account(c4.getId(), new BigDecimal(400)));
			Account a5 = accountRepo.save(new Account(c5.getId(), new BigDecimal(500)));

			// save a couple of transactions random and independently
			transactionRepo.save(new Transaction(c1.getId(), a1.getId(), a2.getId(), new BigDecimal(15)));
			transactionRepo.save(new Transaction(c2.getId(), a2.getId(), a3.getId(), new BigDecimal(50)));
			transactionRepo.save(new Transaction(c3.getId(), a3.getId(), a4.getId(), new BigDecimal(75)));
			transactionRepo.save(new Transaction(c4.getId(), a4.getId(), a5.getId(), new BigDecimal(35)));
			transactionRepo.save(new Transaction(c5.getId(), a5.getId(), a1.getId(), new BigDecimal(150)));
			
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
