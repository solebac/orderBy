package com.erpro.orderby.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erpro.orderby.entities.User;
import com.erpro.orderby.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	/*
	 * 
	@GetMapping
	public ResponseEntity<User> findAll(){
		//Teste
		User u = new User(1L, "Flavio", "Solebac@hotmail.com", "111111", "abc");
		return ResponseEntity.ok().body(u);
	}*/
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.finAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
