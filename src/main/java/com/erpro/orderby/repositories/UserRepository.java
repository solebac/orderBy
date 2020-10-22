package com.erpro.orderby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erpro.orderby.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
