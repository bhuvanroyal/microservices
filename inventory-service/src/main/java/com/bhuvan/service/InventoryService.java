package com.bhuvan.service;

import org.springframework.stereotype.Service;

import com.bhuvan.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

	private InventoryRepository inventoryRepository;
	
	public boolean isInStock(int productId) {
		return inventoryRepository.findByProductId(productId).isPresent();
	}
	
}
