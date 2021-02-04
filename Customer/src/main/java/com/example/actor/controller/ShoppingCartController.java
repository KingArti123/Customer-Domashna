package com.example.actor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.actor.entity.ShoppingCart;
import com.example.actor.services.ShoppingCartServices;

@RestController
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartServices scServices;
	
	@PostMapping(value = "/createSC/{personId}")
	public ShoppingCart createSC (@RequestParam("personId")Integer personId,@RequestBody List<Integer> productId) {
		
		return scServices.createSC(personId,productId);
	}

}
