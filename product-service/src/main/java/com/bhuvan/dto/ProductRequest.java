package com.bhuvan.dto;



import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
	
	@NotEmpty
	private String productName;
	@NotEmpty
	private String productDescription;
	
	private double productPrice;

}
