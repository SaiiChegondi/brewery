package com.spring.demo.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.spring.demo.model.BeerDto;
import com.spring.demo.model.CustomerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public CustomerDto getCustomerById(UUID id) {
		return CustomerDto.builder().id(UUID.randomUUID())
				.name("saii")
				.build();
	}

	@Override
	public CustomerDto SavedNewCustomer(CustomerDto customerDto) {
		return CustomerDto.builder().id(UUID.randomUUID()).build();
				
	}

	@Override
	public void updateCustmer(UUID customerId, CustomerDto customerDto) {
		// TODO Auto-generated method stub
		log.info("updating...");
	}

	@Override
	public void deleteById(UUID customerId) {
		// TODO Auto-generated method stub
		log.info("Deleting....");
	}

}
