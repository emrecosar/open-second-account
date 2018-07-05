package com.emrecosar.opensecondaryaccount.account.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "BALANCE")
	private BigDecimal balance;

	@Column(name = "CUSTOMER_ID")
	private Long customerId;

	public Account() {
	}

	public Account(Long customerId, BigDecimal balance) {
		super();
		this.customerId = customerId;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Id : " + this.getId() + "; Customer Id : " + this.getCustomerId() + "; Balance : " + this.getBalance();
	}
	
}
