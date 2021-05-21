package com.example.demoActiveMQMessageing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class SenderComponent {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String message) {
        System.out.println("Sending string message... " + message);
        jmsTemplate.convertAndSend("stringMessageQueue", message);
        System.out.println("Successfully sent the message... " + message);
    }

    public void sendMessage(Employee employee) {
        System.out.println("Sending employee data... " + employee.toString());
        jmsTemplate.convertAndSend("employeeMessageQueue", employee);
        System.out.println("Successfully sent employee data... " + employee.toString());
    }


}
