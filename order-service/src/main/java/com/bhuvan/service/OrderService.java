package com.bhuvan.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhuvan.dto.OrderItemsDto;
import com.bhuvan.dto.OrderRequest;
import com.bhuvan.entity.Order;
import com.bhuvan.entity.OrderItems;
import com.bhuvan.repository.OrderRepository;

@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	
	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository=orderRepository;
	}
	
	public String placeOrder(OrderRequest orderRequest) {
		Order o=new Order();
		o.setOrderNumber(UUID.randomUUID().toString());
		List<OrderItems> orderItems=orderRequest.getOrderItemList().stream().map(ord->mapToEntity(ord)).toList();
		o.setOrderItems(orderItems);
		o.setOrderTotalAmount(orderRequest.getOrderItemList().stream().mapToDouble(a->a.getPrice()*a.getQuantity()).sum());
		orderRepository.save(o);
		return "Success";
		
	}
	
	public OrderItems mapToEntity(OrderItemsDto o) {
		OrderItems ordItems=new OrderItems();
		ordItems.setPrice(o.getPrice());
		ordItems.setQuantity(o.getQuantity());
		ordItems.setProductId(o.getProductId());
		
		return ordItems;
	}
}
