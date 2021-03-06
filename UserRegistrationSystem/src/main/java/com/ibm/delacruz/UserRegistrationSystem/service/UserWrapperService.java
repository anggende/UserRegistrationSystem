package com.ibm.delacruz.UserRegistrationSystem.service;

import org.springframework.stereotype.Service;

import com.ibm.delacruz.UserRegistrationSystem.domain.User;
import com.ibm.delacruz.UserRegistrationSystem.domain.UserWrapper;

@Service
public class UserWrapperService {

	public UserWrapper createUser(User user) {
		String ACTION = "createUser";
		UserWrapper userWrapper = new UserWrapper();
		userWrapper.setUser(user);
		userWrapper.setAction(ACTION);
		return userWrapper;
	}
	
	public UserWrapper updateUser(User user) {
		String ACTION = "updateUser";
		UserWrapper userWrapper = new UserWrapper();
		userWrapper.setUser(user);
		userWrapper.setAction(ACTION);
		return userWrapper;
	}
	
	public UserWrapper deleteUser(User user) {
		String ACTION = "deleteUser";
		UserWrapper userWrapper = new UserWrapper();
		userWrapper.setUser(user);
		userWrapper.setAction(ACTION);
		return userWrapper;
	}
	
}
