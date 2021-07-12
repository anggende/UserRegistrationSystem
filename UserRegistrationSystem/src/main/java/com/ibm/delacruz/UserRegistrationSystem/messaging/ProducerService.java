package com.ibm.delacruz.UserRegistrationSystem.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.ibm.delacruz.UserRegistrationSystem.domain.User;
import com.ibm.delacruz.UserRegistrationSystem.domain.UserWrapper;

@Service
public class ProducerService {
	private final KafkaTemplate<String,String> kafkaTemplate;
	private final static String TOPIC = "userevents";
	
	public ProducerService(KafkaTemplate<String,String> kafkaTemplate) {
		this.kafkaTemplate=kafkaTemplate;
	}
	
	public void sendMessage(UserWrapper userWrapper) throws JsonProcessingException {
		String userJson = new Gson().toJson(userWrapper);
		kafkaTemplate.send(TOPIC, userJson);
	}

	public void sendMessage(User user) throws JsonProcessingException {
		String userJson = new Gson().toJson(user);
		kafkaTemplate.send(TOPIC, userJson);
	}
}
