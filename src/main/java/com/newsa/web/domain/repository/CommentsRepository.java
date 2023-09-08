package com.newsa.web.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.newsa.web.domain.Comments;

public interface CommentsRepository extends MongoRepository<Comments, String>{

}
