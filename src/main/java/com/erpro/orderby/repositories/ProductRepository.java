package com.erpro.orderby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erpro.orderby.entities.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{
	
}
