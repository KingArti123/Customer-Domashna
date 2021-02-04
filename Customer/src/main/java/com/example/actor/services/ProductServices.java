package com.example.actor.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.actor.entity.Category;

import com.example.actor.entity.DiscountedPrice;
import com.example.actor.entity.Manufactorer;
import com.example.actor.entity.Product;

import com.example.actor.repository.CategoryRepository;
import com.example.actor.repository.ManufactorerRepository;
import com.example.actor.repository.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ManufactorerRepository manufactorerRepo;
	
	@Autowired
	CategoryRepository categoryRepo;

	public Product addProduct(Product product) {
		
		if(manufactorerRepo.existsByManufactorerName(product.getManufactorer().getManufactorerName())) {
			
			Manufactorer man = manufactorerRepo.findByManufactorerName(product.getManufactorer().getManufactorerName());
			
			product.setManufactorer(man);
		}
		
		if(categoryRepo.existsByProductCategory(product.getCategory().getProductCategory())) {
			
			Category cat = categoryRepo.findByProductCategory(product.getCategory().getProductCategory());
			
			product.setCategory(cat);
		}
		
		return productRepository.save(product);
	}

	public Product updateProduct(Integer productId, Product product) {
		
		return productRepository.findById(productId).map(prod -> {
			prod.setProductName(product.getProductName());
			prod.setProductPrice(product.getProductPrice());
			prod.setProductOrigin(product.getProductOrigin());
			prod.setCategory(product.getCategory());
			prod.setManufactorer(product.getManufactorer());
			
			
			
			return productRepository.save(prod);
		}).orElseGet(() ->{
			product.setProductId(productId);
			return productRepository.save(product);
		});
	}

	public void deleteProduct(Integer productId) {
		
		productRepository.deleteById(productId);
		
	}

	public List<Product> getAll() {
		
		return productRepository.findAll();
	}
	
	

	public List<Product> findByProductOrigin(String productOrigin) {
		
		return productRepository.findByProductOrigin(productOrigin);
	}

	public Product getByName(String name) {
		
		return productRepository.getByName(name);
	}

	public List<DiscountedPrice> getDiscount(String productOrigin) {
		
		List<DiscountedPrice> discountByOrigin = new ArrayList<>();
		
		productRepository.findAll().stream().forEach(product -> {
			if(product.getProductOrigin().equals(productOrigin))
		discountByOrigin.add(new DiscountedPrice(product.getProductName(), product.getProductPrice(), product.getProductPrice()*.82));
		});
		
		return discountByOrigin;
	}
	
	

 	

	
	

}
