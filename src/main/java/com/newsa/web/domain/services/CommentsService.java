package com.newsa.web.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsa.web.domain.Comments;
import com.newsa.web.domain.repository.CommentsRepository;

@Service
public class CommentsService {
	
	@Autowired
	private CommentsRepository repository;

	public List<Comments> findAll() {
		return repository.findAll();
	}
	
	public Comments insert(Comments obj) {
		return repository.insert(obj);
	}
}
