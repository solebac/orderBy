package com.erpro.orderby.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.erpro.orderby.entities.User;
import com.erpro.orderby.repositories.UserRepository;
import com.erpro.orderby.resources.exceptions.DatabaseException;
import com.erpro.orderby.service.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<User> finAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		//return obj.get();
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		/* Teste um 
		 * try {
			repository.deleteById(id);	
		} catch (RuntimeException e) {
			e.printStackTrace();
		}*/
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			//e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj) {
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getName());
		entity.setPhone(obj.getPhone());

	}
}
