package com.erpro.orderby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erpro.orderby.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
