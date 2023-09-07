package com.newsa.web.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsa.web.domain.User;
import com.newsa.web.domain.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
}
