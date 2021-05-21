package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class SimpleSender {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(String message) {
		
		System.out.println("Sending message.... " + message);
		jmsTemplate.convertAndSend("mydest",message);
	}
	
	public void sendGift(Gift gift) {
		
		System.out.println("Sending message.... " + gift);
		jmsTemplate.convertAndSend("giftDest",gift);
	}
}
