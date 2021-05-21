package com.example.demoRabbitMQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyReceiver {

    @RabbitListener(queues = "example.queue")
    public void receiveMessage(@Payload Employee employee, @Header("myheader") String header){

        log.debug("Message body = {}",  employee);
        log.debug("Message header = {}", header);
    }
}
