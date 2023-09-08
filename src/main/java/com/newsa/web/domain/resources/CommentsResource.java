package com.newsa.web.domain.resources;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newsa.web.domain.Comments;
import com.newsa.web.domain.services.CommentsService;

@RestController
@RequestMapping(value="/comments")
public class CommentsResource {
	
	@Autowired
	private CommentsService service;

	
	@RequestMapping(value="/addcomment")
	@PostMapping
	public ResponseEntity<Comments> register(@RequestBody Comments obj){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			obj.setDate(date);
			Comments com = service.insert(obj);
			URI uri = URI.create("/users/" + com.getId());
			return ResponseEntity.created(uri).build();
	}
}

