package com.erpro.orderby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erpro.orderby.entities.Category;

public interface CategoryRepository  extends JpaRepository<Category, Long>{
	
}
