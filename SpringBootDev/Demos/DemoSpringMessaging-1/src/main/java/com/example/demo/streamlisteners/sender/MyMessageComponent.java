package com.example.demo.streamlisteners.sender;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.support.JmsHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
public class MyMessageComponent {

	@Value("${destination:test}")
	private String destination;

	@Autowired
	@Qualifier("messageSenderChannel")
	MessageChannel mySender;

	public void sendMessage(String myMesssage) {

		Map<String, Object> headers = Collections.singletonMap(JmsHeaders.DESTINATION, destination);

		for (int i = 0; i < 5; i++) {
			GenericMessage<String> message = new GenericMessage<>(myMesssage + i, headers);
			mySender.send(message);

		}

	}
}
