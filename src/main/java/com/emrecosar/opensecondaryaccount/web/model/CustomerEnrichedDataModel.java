package com.emrecosar.opensecondaryaccount.web.model;

import java.math.BigDecimal;
import java.util.List;

import com.emrecosar.opensecondaryaccount.transaction.model.Transaction;

public class CustomerEnrichedDataModel {

	private String name;

	private String surname;

	private BigDecimal totalBalance;

	private List<Transaction> transactions;

	public CustomerEnrichedDataModel(String name, String surname, BigDecimal totalBalance,
			List<Transaction> transactions) {
		this.name = name;
		this.surname = surname;
		this.totalBalance = totalBalance;
		this.transactions = transactions;
	}

	public CustomerEnrichedDataModel() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public BigDecimal getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(BigDecimal totalBalance) {
		this.totalBalance = totalBalance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
