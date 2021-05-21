package com.example.demoActiveMQMessageing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
public class DemoActiveMqMessageingApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DemoActiveMqMessageingApplication.class, args);
		context.getBean(SenderComponent.class).sendMessage("Hello there!!!");
		context.getBean(SenderComponent.class).sendMessage(new Employee(123, "Nila"));
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {

		MappingJackson2MessageConverter converter =
				new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_id");
		return converter;
	}

}
