package com.bhuvan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhuvan.dto.ProductRequest;
import com.bhuvan.dto.ProductResponse;
import com.bhuvan.exception.ProductNotFoundException;
import com.bhuvan.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	@PostMapping
	public void createProduct(@Valid @RequestBody ProductRequest productRequest) {
		productService.createProduct(productRequest);
	}
	
	@GetMapping
	public List<ProductResponse> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ProductResponse getProductById(@PathVariable Integer id) throws ProductNotFoundException {
			return productService.getProductById(id);
	}
}
