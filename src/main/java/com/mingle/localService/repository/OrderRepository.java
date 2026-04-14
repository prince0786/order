package com.mingle.localService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mingle.localService.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
