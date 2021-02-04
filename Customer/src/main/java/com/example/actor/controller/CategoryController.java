package com.example.actor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.actor.entity.ResponseByCategory;

import com.example.actor.services.CategoryServices;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryServices categoryServices;

	
	@GetMapping(value = "/getByCategory/{category}")
	public List<ResponseByCategory> getByCategory(@RequestParam("category") String category) {
		
		return categoryServices.getByCategory(category);
		 
		  
	}
}
