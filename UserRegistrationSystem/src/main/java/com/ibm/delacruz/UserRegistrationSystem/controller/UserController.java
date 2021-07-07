package com.ibm.delacruz.UserRegistrationSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ibm.delacruz.UserRegistrationSystem.bean.UserBean;
import com.ibm.delacruz.UserRegistrationSystem.domain.User;
import com.ibm.delacruz.UserRegistrationSystem.messaging.ProducerService;
import com.ibm.delacruz.UserRegistrationSystem.service.UserService;
@RestController
public class UserController {

	private UserService userService;
	private ProducerService producerService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Autowired
	public void setProducerService(ProducerService producerService) {
		this.producerService = producerService;
	}

	@PostMapping(value="/user/add",consumes="application/json",produces="application/json")
	public String addUser(@RequestBody UserBean userBean) {
		try {
			producerService.sendMessage(userBean.convertToUser());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return userService.addUser(userBean.convertToUser());
	}
	
	@PutMapping(value="/user/update/{id}")
	public String updateUser(@PathVariable("id") Long id,@RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@GetMapping(value="/user/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		return userService.findById(id);
	}
	
	@GetMapping(value="/user")
	public User getUserByEmail(@RequestParam String email) {
		return userService.findByEmail(email);
	}
	
	@DeleteMapping(value="/user/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		return userService.deleteUser(id);
	}
}
