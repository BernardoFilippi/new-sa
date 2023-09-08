package com.newsa.web.domain.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newsa.web.domain.User;
import com.newsa.web.domain.services.UserService;
import com.newsa.web.domain.services.exceptions.InvalidUsername;

@RestController
@RequestMapping(value="/users")
@CrossOrigin
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
	@PostMapping(value="/register")
	public ResponseEntity<?> register(@RequestBody User obj){
		try {
			User user = service.insert(obj);
			URI uri = URI.create("/users" + user.getId());
			return ResponseEntity.created(uri).build();
		}catch (InvalidUsername e) {
			return ResponseEntity.badRequest().body("Username already exists!");
		
		}
	}
}