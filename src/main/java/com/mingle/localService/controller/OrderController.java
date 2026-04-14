package com.mingle.localService.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mingle.localService.dto.OrderRequest;
import com.mingle.localService.entity.Order;
import com.mingle.localService.entity.OrderStatus;
import com.mingle.localService.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")  //api/v1 -> 
public class OrderController {

	
	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping("/bulk")
	public ResponseEntity<List<Order>> createOrders(
			@RequestBody List<OrderRequest> request){
		
		List<Order> savedOrders = orderService.createOrders(request);
		return ResponseEntity.ok(savedOrders);
	}
	@PutMapping("/{orderId}/status/{status}")
	public ResponseEntity<Order> updateStatus(
			@PathVariable Long orderId,
			@PathVariable OrderStatus status){
		
		Order order = orderService.updateStatus(orderId, status);
		return ResponseEntity.ok(order);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable Long id){
		return ResponseEntity.ok(orderService.getOrderById(id));
	}
}
