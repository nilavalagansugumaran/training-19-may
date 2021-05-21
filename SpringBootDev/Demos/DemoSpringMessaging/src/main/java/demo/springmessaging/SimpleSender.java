package demo.springmessaging;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class SimpleSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendSimpleMessage(String message) {
    
		String messageToSend = message + " [" + new Date() + "]";
        System.out.println("Sending: " + messageToSend);
        jmsTemplate.convertAndSend("simpleDest", messageToSend);	
        
        try {
        	Thread.sleep(300); 
        } 
        catch (Exception ex) {}
    }
}