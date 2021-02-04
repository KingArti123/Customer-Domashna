package com.example.actor.services;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.actor.entity.Customer;

import com.example.actor.entity.Product;
import com.example.actor.entity.ShoppingCart;
import com.example.actor.repository.CustomerRepository;
import com.example.actor.repository.ProductRepository;
import com.example.actor.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServices {
	
	@Autowired
	ShoppingCartRepository scRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProductRepository productRepository;
	

	public ShoppingCart createSC(Integer personId,List<Integer> productId) {
		
		ShoppingCart scart = new ShoppingCart();
		
		Date date = new Date(System.currentTimeMillis());
		
		Customer customer = customerRepository.findById(personId).get();
		
		List<Product> products = productRepository.findAllById(productId);
		
		scart.setCreatedOn(date);
		scart.setCustomer(customer);
		scart.setProducts(products);
		return scRepository.save(scart);
	}

	
	
	
	

}
