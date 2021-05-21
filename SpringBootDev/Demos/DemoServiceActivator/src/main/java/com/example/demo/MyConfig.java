package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@Configuration
public class MyConfig {

	@Bean
	public DirectChannel myInputChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public QueueChannel myOutputChannel() {
		return new QueueChannel(10);
	}
	
//	@ServiceActivator(inputChannel = "myInputChannel", outputChannel = "myOutputChannel")
//	public String myActivator(Message<?> mess) {
//		System.out.println(mess.getPayload().toString());
//		return mess.getPayload().toString();
//	}
	
	@Bean
	@ServiceActivator(inputChannel = "myInputChannel")
	public MessageHandler handler() {
	    return new MessageHandler() {
	        @Override
	        public void handleMessage(Message<?> message) throws MessagingException {
	            
	                try {
	                   System.out.println("Using simple handler..." + message.getPayload().toString());
	                    
	                } catch (Exception e) {
	                    throw new MessagingException("Exception handling message", e);
	                }
	            
	        }
	    };
	}
}
