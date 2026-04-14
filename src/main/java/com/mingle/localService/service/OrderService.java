package com.mingle.localService.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.mingle.localService.dto.OrderRequest;
import com.mingle.localService.dto.ParcelRequest;
import com.mingle.localService.entity.Order;
import com.mingle.localService.entity.OrderStatus;
import com.mingle.localService.entity.Parcel;
import com.mingle.localService.repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class OrderService {

	private final OrderRepository orderRepository;
	
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public List<Order> createOrders( List<OrderRequest> request) {
		List<Order> orders = new ArrayList<>();
		for(OrderRequest request1 : request) {
			
		    Order order = new Order();
		    order.setOrderNumber(request1.getOrderNumber());
		
		    List<Parcel> parcelList = new ArrayList<>();
		
		for(ParcelRequest pr : ( request1.getParcels())) {
			Parcel parcel = new Parcel();
			parcel.setParcelNumber(pr.getParcelNumber());
			parcel.setWeight(pr.getWeight());
			parcel.setOrder(order);
			parcelList.add(parcel);
		}
		
		order.setParcels(parcelList);
		orders.add(order);
		}
		
		return orderRepository.saveAll(orders);
	}

	public Order updateStatus(Long orderId, OrderStatus status) {
		// TODO Auto-generated method stub
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new EntityNotFoundException("Order not found"));
		order.setStatus(status);
		return orderRepository.save(order);
	}
	
	public Order getOrderById(Long id) {
	    return orderRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("Order not found"));
	}

	

	
}
