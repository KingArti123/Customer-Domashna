 package com.example.actor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.actor.entity.Address;
import com.example.actor.entity.Customer;
import com.example.actor.repository.AddressRepository;
import com.example.actor.repository.CustomerRepository;

@Service
public class CustomerServices {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AddressRepository addressRepository;

	public Customer createCustomer(Customer customer) {
		
		if(addressRepository.existsById(customer.getAddress().getAddressId())) {
			
			Address adr = addressRepository.findById(customer.getAddress().getAddressId()).get();
			
			customer.setAddress(adr);
		}
		
		return customerRepository.save(customer);
	}

	public Customer updateCustomer(Integer customerId, Customer customer) {
		
		return customerRepository.findById(customerId).map(cust -> { 
			cust.setFirstName(customer.getFirstName());
			cust.setLastName(customer.getLastName());
			cust.setAddress(customer.getAddress());
			return customerRepository.save(cust);
		}).orElseGet(() -> {
			customer.setCustomerId(customerId);
			return customerRepository.save(customer);
		});
	}
	

	
	

	public void deleteCustomer(Integer customerId) {
		
		customerRepository.deleteById(customerId);
		
	}

	
	
	
}
