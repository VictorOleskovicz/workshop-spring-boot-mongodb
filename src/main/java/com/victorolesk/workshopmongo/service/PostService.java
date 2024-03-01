package com.victorolesk.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorolesk.workshopmongo.domain.Posts;
import com.victorolesk.workshopmongo.repository.PostRepository;
import com.victorolesk.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Posts findById(String id) {
		Optional<Posts> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));

}

	public List<Posts> findByTitle(String text) {
		return repo.findByTitleContaining(text);
	}
}
