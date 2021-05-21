package demo.springmessaging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleReceiver {

	@Value("${filename}")
	private String filename;

	@JmsListener(destination="simpleDest", containerFactory="myFactory")
	public void receiveSimpleMessage(String message) {
		
		try {			
			String str = "Simple message received [" + new Date() + "] " + message;
			System.out.println(str);
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
			bw.append(str);
			bw.newLine();
			bw.close();	
		} 
		catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
