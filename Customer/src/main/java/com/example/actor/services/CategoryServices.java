package com.example.actor.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.actor.entity.ResponseByCategory;
import com.example.actor.repository.CategoryRepository;
import com.example.actor.repository.ProductRepository;

@Service
public class CategoryServices {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	

        public List<ResponseByCategory> getByCategory(String category) {
		
		List<ResponseByCategory> result = new ArrayList<>();
		
		productRepository.findAll().stream().forEach(product -> {
			if(product.getCategory().getProductCategory().equals(category))
			result.add(new ResponseByCategory(product.getProductName(), product.getProductPrice(), product.getCategory().getProductCategory()));
		});
		return result;
		
	/*	for (Product product2 : all) {
			
			if(product2.getCategory().getProductCategory().equals(category)) {
				
			    ResponseByCategory response = new ResponseByCategory();
				
				response.setProductCategory(product2.getCategory().getProductCategory());
				response.setProductName(product2.getProductName());
				response.setProductPrice(product2.getProductPrice());
				
				result.add(response);
				
			}
		}
		return categoryRepository.findByCategory(category);
		
		  */
		
		
	}
	
	
}
