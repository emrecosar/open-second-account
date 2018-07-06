package com.emrecosar.opensecondaryaccount.web.model;

import java.math.BigDecimal;

public class AccountModel {

	private Long id;

	private BigDecimal balance;

	private Long customerId;

	public AccountModel() {
	}

	public AccountModel(Long id, Long customerId, BigDecimal balance) {
		this.id = id;
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
