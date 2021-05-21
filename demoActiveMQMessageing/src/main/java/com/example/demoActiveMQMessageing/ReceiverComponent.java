package com.example.demoActiveMQMessageing;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverComponent {

    @JmsListener(destination = "stringMessageQueue")
    public void stringMessageReceiver(String message){
        System.out.println("Successfully received string message..." + message);
    }

    @JmsListener(destination = "employeeMessageQueue")
    public void stringMessageReceiver(Employee employee){
        System.out.println("Successfully received employee data..." + employee.toString());
    }

}
