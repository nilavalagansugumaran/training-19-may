package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

@SpringBootApplication
public class DemoServiceActivatorApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoServiceActivatorApplication.class, args);
		MessageChannel inputChannel = ctx.getBean("myInputChannel", MessageChannel.class);
		inputChannel.send(new GenericMessage<String>("World"));
	}

}
