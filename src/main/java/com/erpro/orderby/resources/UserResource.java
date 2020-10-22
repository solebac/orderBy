package com.erpro.orderby.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erpro.orderby.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		//Teste
		User u = new User(1L, "Flavio", "Solebac@hotmail.com", "111111", "abc");
		return ResponseEntity.ok().body(u);
	}
}
