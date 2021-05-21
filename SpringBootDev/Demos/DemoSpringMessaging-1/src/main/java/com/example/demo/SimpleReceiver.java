package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleReceiver {

	@JmsListener(destination = "mydest")
	public void processMessage(String message) {
		
		System.out.println("received messgae...." + message);
	}
	
	@JmsListener(destination = "giftDest")
	public void processGift(Gift gift) {
		
		System.out.println("received gift...." + gift.toString());
	}
}
