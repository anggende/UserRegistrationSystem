package com.ibm.delacruz.UserRegistrationSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.delacruz.UserRegistrationSystem.domain.User;
import com.ibm.delacruz.UserRegistrationSystem.exception.UserNotFoundException;
import com.ibm.delacruz.UserRegistrationSystem.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public void addUser(User user) {
		repository.save(user);
	}
	
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}
	
	public User findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public User findByEmail(String email) {
		return repository.findByEmail(email).orElse(null);
	}
	
	public String updateUser(Long id, User user) {
		if (repository.findById(id).isPresent()) {
			repository.save(user);
			return "successfully updated user";
		}
		return "update failed";
	}

}
