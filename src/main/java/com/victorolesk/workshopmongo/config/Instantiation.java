package com.victorolesk.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.victorolesk.workshopmongo.domain.Posts;
import com.victorolesk.workshopmongo.domain.User;
import com.victorolesk.workshopmongo.repository.PostRepository;
import com.victorolesk.workshopmongo.repository.UserRepository;
import com.victorolesk.workshopmongo.dto.AuthorDTO;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com"); 
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		
		Posts post1 = new Posts(null, sdf.parse("28/10/2017"), "Travelling", "Just reached Madrid!", new AuthorDTO(maria));
		Posts post2 = new Posts(null, sdf.parse("20/10/2018"), "Cooking", "Made some cookies!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
