package com.spring.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.model.CustomerDto;
import com.spring.demo.services.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> GetCustomer(@PathVariable UUID id)
	{
		return new ResponseEntity<>(customerService.getCustomerById(id),HttpStatus.OK);
	}
	
	
	@PostMapping 
	public ResponseEntity handlePost(@RequestBody CustomerDto customerDto)
	{
		CustomerDto savedDto=customerService.SavedNewCustomer(customerDto);
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.add("Loacation","/api/v1/customers"+savedDto.getId().toString());
		return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void habdleupdate(@PathVariable UUID customerId,@RequestBody CustomerDto customerDto)
	{
		customerService.updateCustmer(customerId,customerDto);
	}
	
	@DeleteMapping("/{customerId}")
	public void deleteById(@PathVariable UUID customerId)
	{
		customerService.deleteById(customerId);
	}
}
