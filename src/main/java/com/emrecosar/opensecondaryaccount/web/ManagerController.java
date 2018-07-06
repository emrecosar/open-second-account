package com.emrecosar.opensecondaryaccount.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emrecosar.opensecondaryaccount.customer.model.Customer;
import com.emrecosar.opensecondaryaccount.service.ManagerService;
import com.emrecosar.opensecondaryaccount.web.model.AccountModel;
import com.emrecosar.opensecondaryaccount.web.model.CustomerEnrichedDataModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "Manager Controller for open account and get user")
public class ManagerController {

	ManagerService managerService;

	@Autowired
	public ManagerController(ManagerService managerService) {
		this.managerService = managerService;
	}

	@ApiOperation(value = "create secondary account")
	@PostMapping(value = "/account")
	public ResponseEntity<?> openSecondaryAccount(
			@RequestParam(value = "customerId", required = true) @ApiParam(value = "customer id", example = "1") Long customerId,
			@RequestParam(value = "initialCredit", required = true) @ApiParam(value = "initial credit", example = "10") BigDecimal initialCredit)
			throws IOException {

		Optional<Customer> customer = managerService.getCustomer(customerId);

		if (customer.isPresent()) {
			return new ResponseEntity<String>("Customer not found!", HttpStatus.NOT_FOUND);
		} else {

			AccountModel secondaryAccount = managerService.createSecondaryAccount(customer.get(), initialCredit);
			if(secondaryAccount == null) {
				return new ResponseEntity<String>("Customer must have at least one account!", HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<AccountModel>(secondaryAccount, HttpStatus.CREATED);
		}

	}

	@ApiOperation(value = "retreive customer informations with transactions")
	@GetMapping(value = "/customer/{customerId}")
	public ResponseEntity<?> getCustomerInformation(
			@PathVariable(value = "customerId", required = true) @ApiParam(value = "customer id", example = "1") Long customerId)
			throws IOException {

		Optional<Customer> customer = managerService.getCustomer(customerId);
		if (customer.isPresent())
			return new ResponseEntity<String>("Customer not found!", HttpStatus.NOT_FOUND);

		CustomerEnrichedDataModel response = managerService.aggregateCustomerData(customer.get());

		return new ResponseEntity<CustomerEnrichedDataModel>(response, HttpStatus.CREATED);
	}

}
