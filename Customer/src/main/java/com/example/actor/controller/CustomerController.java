package com.example.actor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.actor.entity.Customer;
import com.example.actor.services.CustomerServices;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerServices customerServices;
	
	@PostMapping(value = "/createCustomer")
	public Customer createCustomer(@RequestBody Customer customer) {
		
		return customerServices.createCustomer(customer);
	}
	
	@PutMapping(value = "/updateCustomer/{customerId}")
	public Customer updateCustomer(@RequestParam Integer customerId, @RequestBody Customer customer ) {
		
		return customerServices.updateCustomer(customerId ,customer);
	}
	
	
	
	
	@DeleteMapping(value = "/deleteCustomer/{customerId}")
	public String deleteCustomer(@PathVariable Integer customerId) {
		
		customerServices.deleteCustomer(customerId);
		
		return "Customer was deleted";
	}
	
	

}
