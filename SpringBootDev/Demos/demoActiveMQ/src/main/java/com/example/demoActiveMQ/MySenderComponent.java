package com.example.demoActiveMQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MySenderComponent {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendSimpleMessage(String message) {

        log.debug("sending simple message >>> {}" , message);
        jmsTemplate.convertAndSend("simpleMessageBox", message);
    }

    public void sendEmpMessage(Employee employee) {

        log.debug("sending employee message >>> {}" , employee);
        jmsTemplate.convertAndSend("employeeMessageBox", employee);
    }
}
