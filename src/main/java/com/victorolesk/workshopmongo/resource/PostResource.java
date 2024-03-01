package com.victorolesk.workshopmongo.resource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victorolesk.workshopmongo.domain.Posts;
import com.victorolesk.workshopmongo.resource.util.URI;
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
	
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
 	public ResponseEntity<List<Posts>> findByTitle(@RequestParam(value="text", defaultValue = "") String text) {
		text = URI.decodePatter(text);
		List<Posts> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	
	
	
	
}