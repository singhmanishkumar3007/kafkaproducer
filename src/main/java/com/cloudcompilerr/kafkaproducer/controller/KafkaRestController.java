package com.cloudcompilerr.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudcompilerr.kafkaproducer.service.KafkaProducerService;

@RestController
public class KafkaRestController {

	@Autowired
	private KafkaProducerService kafkaProducerService;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) {
		kafkaProducerService.send(message);
		

		return "Message sent to the Kafka Topic manish-test Successfully";
	}

}
