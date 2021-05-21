package com.example.demoRabbitMQ;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRabbitConfig {

    // message converter
    @Bean
    Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // message queue
    @Bean
    Queue queue() {

        return QueueBuilder.durable("example.queue").build();
    }

    // create an exchange
    @Bean
    Exchange myExcahnge() {

        return ExchangeBuilder.directExchange("example.exchange").build();
    }

    // binding exchange and queue
    @Bean
    Binding binding(Queue q, Exchange exchange){
        return BindingBuilder.bind(q).to(exchange).with("example.key").noargs();
    }
}
