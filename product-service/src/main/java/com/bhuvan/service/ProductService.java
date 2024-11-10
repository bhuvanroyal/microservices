package com.bhuvan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bhuvan.dto.ProductRequest;
import com.bhuvan.dto.ProductResponse;
import com.bhuvan.entity.Product;
import com.bhuvan.repository.ProductRepository;


@Service
public class ProductService {

	
	private final ProductRepository productRepository;
	public ProductService(ProductRepository productRepository){
		this.productRepository=productRepository;
	}
	
	public void createProduct(ProductRequest productRequest) {
		Product product=Product.builder().productDescription(productRequest.getProductDescription())
				.productName(productRequest.getProductName())
				.productPrice(productRequest.getProductPrice())
				.build();
		
		productRepository.save(product);
		
	}
	
	public List<ProductResponse> getAllProducts() {
		List<Product> products=productRepository.findAll();
		
		return	products.stream().map(p->ProductResponse.builder().productId(p.getProductId())
				.productName(p.getProductName())
				.productDescription(p.getProductDescription())
				.productPrice(p.getProductPrice()).build()).toList();
				
	}
	
}