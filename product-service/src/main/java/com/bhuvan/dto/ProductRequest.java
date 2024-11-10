package com.bhuvan.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
	
	private String productName;
	private String productDescription;
	private double productPrice;

}
