package com.victorolesk.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.victorolesk.workshopmongo.domain.Posts;

@Repository
public interface PostRepository extends MongoRepository<Posts, String> {

	List<Posts> findByTitleContaining(String text);
	
	}
	

