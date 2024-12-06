package com.bhuvan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsDto {

	private Long id;
	private Integer productId;
	private double price;
	private int quantity;
}
