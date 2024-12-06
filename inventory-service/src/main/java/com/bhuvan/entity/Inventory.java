package com.bhuvan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Inventory {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long inventoryId;
	private Integer productId;
	private Integer quantity;
	
}
