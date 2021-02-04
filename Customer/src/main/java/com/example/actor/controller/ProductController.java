package com.example.actor.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.actor.entity.DiscountedPrice;
import com.example.actor.entity.Product;

import com.example.actor.services.ProductServices;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	

	@Autowired
	ProductServices productServices;
	
	@PostMapping(value = "/addProduct")
	public Product addProduct(@RequestBody Product product) {
		
	return	productServices.addProduct(product);
	}
	
	@PutMapping(value = "/updateProduct/{productId}")
	public Product updateProduct(@PathVariable Integer productId,@RequestBody Product product) {
		
		return productServices.updateProduct(productId, product);
	}
	
	@DeleteMapping(value = "/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable Integer productId) {
		
		productServices.deleteProduct(productId);
		
		return "Product was deleted";
	}
	@GetMapping(value = "/getAll")
	public List<Product> getAll() {
		
		return productServices.getAll();
		
	}
	
	@GetMapping(value = "/allByOrigin/{productOrigin}")
	public List<Product>allByOrigin(@RequestParam("productOrigin") String productOrigin) {
		
		return productServices.findByProductOrigin(productOrigin);
	}
	
	@GetMapping(value = "/getByName/{name}")
	public Product getByName(@RequestParam("name") String name) {
		
		return productServices.getByName(name);
	}
	
	@GetMapping(value = "/discount/{productOrigin}")
	public List<DiscountedPrice> getDiscount(@RequestParam("productOrigin")String productOrigin){
		
		return productServices.getDiscount(productOrigin);
	}
	
	
}
