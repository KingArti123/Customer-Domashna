package com.example.actor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountedPrice {
	
	private String productName;
	
	private Double productPrice;
	
	private Double discountedPrice;
	

}
