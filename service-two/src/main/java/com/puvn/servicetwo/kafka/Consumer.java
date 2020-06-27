package com.puvn.servicetwo.kafka;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.puvn.servicetwo.model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eugeniy Lukin (eugeniylukin@gmail.com) created on 27.06.2020.
 */
@Service
public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	private Map<String, Payment> payments = new HashMap<>();

	private final ObjectMapper objectMapper = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	@KafkaListener(topics = "RAW_PAYMENTS", groupId = "group_id17")
	public void consume(String message) throws IOException {
		var payment = toModelClass(message, Payment.class);
		payments.put(payment.getRef(), payment);
		logger.info(String.format("#### -> Consumed message -> %s", payment));
	}

	public Map<String, Payment> getPayments() {
		return payments;
	}

	private <T> T toModelClass(String string, Class<T> clazz) throws IOException {
		return this.objectMapper.readValue(string, clazz);
	}
}