package com.victorolesk.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorolesk.workshopmongo.domain.User;
import com.victorolesk.workshopmongo.dto.UserDTO;
import com.victorolesk.workshopmongo.repository.UserRepository;
import com.victorolesk.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}

	public void deleteById(String id) {

		if (!(findById(id) == null)) {

			repo.findById(id);
			repo.deleteById(id);
		}
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId()); 
		updateData(newObj, obj);
		return repo.save(newObj);
		
		
		
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}
	
	
	

}
