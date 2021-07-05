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
	
	public String addUser(User user) {
		repository.save(user);
		return "saved user";
	}
	
	public String deleteUser(Long id) {
		repository.deleteById(id);
		return "deleted user";
	}
	
	public User findById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public User findByEmail(String email) {
		return repository.findByEmail(email).orElse(null);
	}
	
	public String updateUser(Long id,User user) {
		if (repository.findById(id).isPresent()) {
			User updatedUser = new User();
			updatedUser.setId(id);
			updatedUser.setFirstName(user.getFirstName());
			updatedUser.setLastName(user.getLastName());
			updatedUser.setUsername(user.getUsername());
			updatedUser.setEmail(user.getEmail());
			updatedUser.setPassword(user.getPassword());
			updatedUser.setBirthday(user.getBirthday());
			repository.save(updatedUser);
			return "successfully updated user";
		}
		return "update failed";
	}

}
