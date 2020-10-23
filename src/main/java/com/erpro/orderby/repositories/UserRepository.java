package com.erpro.orderby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erpro.orderby.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
