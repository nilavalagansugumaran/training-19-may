package com.example.demo.streamlisteners.sender;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.jms.ChannelPublishingJmsMessageListener;
import org.springframework.integration.jms.JmsMessageDrivenEndpoint;
import org.springframework.jms.listener.SimpleMessageListenerContainer;

@Configuration
public class MessageReaderConfig {

	
	  @Value("${destination:test}")
	  private String destination;

	  @Bean
	  public DirectChannel messageReaderChannel() {
	    return new DirectChannel();
	  }
	  
	  @Bean
	  public JmsMessageDrivenEndpoint jmsMessageDrivenEndpoint(
	      ConnectionFactory connectionFactory) {
	    JmsMessageDrivenEndpoint endpoint = new JmsMessageDrivenEndpoint(
	        simpleMessageListenerContainer(connectionFactory),
	        channelPublishingJmsMessageListener());
	    endpoint.setOutputChannel(messageReaderChannel());

	    return endpoint;
	  }

	  @Bean
	  public SimpleMessageListenerContainer simpleMessageListenerContainer(
	      ConnectionFactory connectionFactory) {
	    SimpleMessageListenerContainer container =
	        new SimpleMessageListenerContainer();
	    container.setConnectionFactory(connectionFactory);
	    container.setDestinationName(destination);
	    return container;
	  }

	  @Bean
	  public ChannelPublishingJmsMessageListener channelPublishingJmsMessageListener() {
	    return new ChannelPublishingJmsMessageListener();
	  }
	  
	  @Bean
	  @ServiceActivator(inputChannel = "messageReaderChannel")
	  public MyMessageHandler countDownLatchHandler() {
	    return new MyMessageHandler();
	  }
}
