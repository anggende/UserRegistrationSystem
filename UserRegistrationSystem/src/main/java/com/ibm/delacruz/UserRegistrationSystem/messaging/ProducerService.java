package com.ibm.delacruz.UserRegistrationSystem.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ibm.delacruz.UserRegistrationSystem.domain.User;

@Service
public class ProducerService {
	private final KafkaTemplate<String,User> kafkaTemplate;
	private final static String TOPIC = "user_events";
	
	public ProducerService(KafkaTemplate<String,User> kafkaTemplate) {
		this.kafkaTemplate=kafkaTemplate;
	}
	
	public void sendMessage(User user) throws JsonProcessingException {
		kafkaTemplate.send(TOPIC,user); 
	}
	
}
