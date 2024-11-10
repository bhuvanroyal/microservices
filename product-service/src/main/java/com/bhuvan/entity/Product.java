package com.bhuvan.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Product {
	@Id
	private String productId;
	private String productName;
	private String productDescription;
	private double productPrice;
	

}
