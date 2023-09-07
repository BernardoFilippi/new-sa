package com.newsa.web.domain.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newsa.web.domain.User;
import com.newsa.web.domain.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<Void> register(@RequestBody User obj){
	User user = service.insert(obj);
	URI uri = URI.create("/users" + user.getId());
	return ResponseEntity.created(uri).build();
	}
}
