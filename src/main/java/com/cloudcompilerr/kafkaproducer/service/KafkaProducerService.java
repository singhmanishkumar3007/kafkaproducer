package com.cloudcompilerr.kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private static final String KAFKA_TOPIC = "manish-test";

	public void send(String message) {

		kafkaTemplate.send(KAFKA_TOPIC, message);
	}

}
