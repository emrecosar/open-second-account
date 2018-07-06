package com.emrecosar.opensecondaryaccount.web.model;

import java.math.BigDecimal;

public class TransactionModel {

	private Long id;

	private Long fromCustomer;

	private Long fromAccount;

	private Long toAccount;

	private BigDecimal amount;

	public TransactionModel() {
	}

	public TransactionModel(Long id, Long fromCustomer, Long fromAccount, Long toAccount, BigDecimal amount) {
		this.id = id;
		this.fromCustomer = fromCustomer;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFromCustomer() {
		return fromCustomer;
	}

	public void setFromCustomer(Long fromCustomer) {
		this.fromCustomer = fromCustomer;
	}

	public Long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Long getToAccount() {
		return toAccount;
	}

	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Id : " + this.getId() + "; From Customer Id : " + this.getFromCustomer() + "; From Account Id : "
				+ this.getFromAccount() + "; To Account Id : " + this.getToAccount() + "; Amount : " + this.getAmount();
	}

}
