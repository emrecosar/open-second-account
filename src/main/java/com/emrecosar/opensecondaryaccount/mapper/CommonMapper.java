package com.emrecosar.opensecondaryaccount.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.emrecosar.opensecondaryaccount.account.model.Account;
import com.emrecosar.opensecondaryaccount.customer.model.Customer;
import com.emrecosar.opensecondaryaccount.transaction.model.Transaction;
import com.emrecosar.opensecondaryaccount.web.model.AccountModel;
import com.emrecosar.opensecondaryaccount.web.model.CustomerModel;
import com.emrecosar.opensecondaryaccount.web.model.TransactionModel;

@Mapper(componentModel = "spring")
public interface CommonMapper {

	CommonMapper INSTANCE = Mappers.getMapper(CommonMapper.class);
	
	AccountModel toAccountModel(Account account);
	
	CustomerModel toCustomerModel(Customer customer);
	
	TransactionModel toTransactionModel(Transaction transaction);
	
	List<TransactionModel> toTransactionsModel(List<Transaction> transactions);
	
}
