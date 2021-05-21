package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import com.example.demo.streamlisteners.sender.MyMessageComponent;

@SpringBootApplication
public class DemoSpringMessagingApplication {

	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoSpringMessagingApplication.class, args);
		SimpleSender sender = context.getBean(SimpleSender.class);
		sender.sendMessage("Hello nila");
		
		Gift mySpecialGift = new Gift("somewhere in london", "somwhere in scotland", 2.5, 500, "my special gift");
		sender.sendGift(mySpecialGift);
	     
		MyMessageComponent messageSender = context.getBean(MyMessageComponent.class);
		messageSender.sendMessage("Hello nila here... ");
//		
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
