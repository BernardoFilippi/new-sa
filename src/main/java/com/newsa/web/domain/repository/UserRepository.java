package com.newsa.web.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.newsa.web.domain.User;

public interface UserRepository extends MongoRepository<User, String>{

	boolean existsByName(String name);
}
