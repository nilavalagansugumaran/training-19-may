package com.example.demoRabbitMQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyRabbitSender {

    @Autowired private RabbitTemplate rabbitTemplate;

    public void sendEmpMessage(Employee employee) {

        log.debug("sending employee message >>> {}" , employee);
        rabbitTemplate.convertAndSend("example.exchange", "example.key", employee,  message -> {
            message.getMessageProperties().setHeader("myheader","hello - this is message 2");
            return message;
        } );
    }
}
