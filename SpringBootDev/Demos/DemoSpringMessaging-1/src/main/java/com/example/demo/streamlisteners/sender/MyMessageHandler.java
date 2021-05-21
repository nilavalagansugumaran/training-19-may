package com.example.demo.streamlisteners.sender;

import org.springframework.messaging.MessageHandler;

public class MyMessageHandler implements MessageHandler {
	
	  @Override
	  public void handleMessage(org.springframework.messaging.Message<?> message) {
	    System.out.println("received message=" + message);
	 
	  }

}
