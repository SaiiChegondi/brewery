package com.spring.demo.services;

import java.util.UUID;

import com.spring.demo.model.CustomerDto;

public interface CustomerService {

	CustomerDto getCustomerById(UUID id);

	CustomerDto SavedNewCustomer(CustomerDto customerDto);

	void updateCustmer(UUID customerId, CustomerDto customerDto);

	void deleteById(UUID customerId);

}
