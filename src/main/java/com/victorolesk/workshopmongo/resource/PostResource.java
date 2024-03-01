package com.victorolesk.workshopmongo.resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.victorolesk.workshopmongo.domain.Posts;
import com.victorolesk.workshopmongo.service.PostService;
@RestController
@RequestMapping(value="/posts")
public class PostResource {
	@Autowired
	private PostService service;
	

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<Posts> findById(@PathVariable String id) {
		Posts obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	
	
}