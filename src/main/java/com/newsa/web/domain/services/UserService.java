package com.newsa.web.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsa.web.domain.User;
import com.newsa.web.domain.repository.UserRepository;
import com.newsa.web.domain.services.exceptions.InvalidUsername;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User insert(User obj) {
		if(repository.existsByName(obj.getName())){
			throw new InvalidUsername("Username already exists!");
		}
		return repository.insert(obj);
	}
}
