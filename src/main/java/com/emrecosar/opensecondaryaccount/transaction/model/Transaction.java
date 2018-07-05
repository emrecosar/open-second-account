package com.emrecosar.opensecondaryaccount.transaction.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "FROM_CUSTOMER")
	private Long fromCustomer;

	@Column(name = "FROM_ACCOUNT")
	private Long fromAccount;

	@Column(name = "TO_ACCOUNT")
	private Long toAccount;

	@Column(name = "AMOUNT")
	private BigDecimal amount;

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
