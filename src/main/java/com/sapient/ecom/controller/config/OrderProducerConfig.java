package com.sapient.ecom.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class OrderProducerConfig {

	final private String TOPIC = "order";

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	public String callBilling() {
		kafkaTemplate.send(TOPIC, new Object());
		return "send";
	}
}
