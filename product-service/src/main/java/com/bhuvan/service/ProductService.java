package com.bhuvan.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bhuvan.dto.ProductRequest;
import com.bhuvan.dto.ProductResponse;
import com.bhuvan.entity.Product;
import com.bhuvan.exception.ProductNotFoundException;
import com.bhuvan.repository.ProductRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Service
public class ProductService {

	private ModelMapper mapper;
	
	private ProductRepository productRepository;
	
	public void createProduct(ProductRequest productRequest) {
//		Product product=Product.builder().productDescription(productRequest.getProductDescription())
//				.productName(productRequest.getProductName())
//				.productPrice(productRequest.getProductPrice())
//				.build();
		Product product=mapper.map(productRequest,Product.class);
		productRepository.save(product);
		
	}
	
	public List<ProductResponse> getAllProducts() {
		List<Product> products=productRepository.findAll();
		
		return	products.stream().map(p->mapper.map(p, ProductResponse.class)).toList();
				
	}

	public ProductResponse getProductById(Integer id) throws ProductNotFoundException {
		Product product=productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("product not exist"));
		ProductResponse response=mapper.map(product, ProductResponse.class);
		return response;
	}
	
}
