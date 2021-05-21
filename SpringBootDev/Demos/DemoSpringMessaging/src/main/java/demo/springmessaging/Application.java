package demo.springmessaging;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Application.class, args);

		// Send 5 simple messages.
		SimpleSender sender1 = context.getBean(SimpleSender.class);
		for(int i = 0; i < 5; i++) {
			sender1.sendSimpleMessage("This is message " + i);
		}
		
		// Send 5 stock ticker alert messages.
		StockTickerAlertSender sender2 = context.getBean(StockTickerAlertSender.class);
		for(int i = 0; i < 5; i++) {
	        sender2.sendStockTickerAlertMessage(StockTickerAlert.generateRandomStockTickerAlert());
		}		
		System.out.println("Good bye :-)");
	}
	
	// This bean is necessary, to allow custom objects to be passed as message payloads (this converter converts objects to/from JSON).
	@Bean 
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_id");
        return converter;
    }
	
	// This bean is not really needed - it just does exactly what the default container factory would do in Spring Boot.
	@Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

        // This provides all boot's default to this factory, including the message converter.
        // You can override some of Boot's default if necessary.
        configurer.configure(factory, connectionFactory);

        return factory;
    }
}
