package demo.additionaltechniques;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Lazy;
import org.springframework.beans.factory.annotation.Value;

@Component
@Lazy
public class MyBean2a {

	@Value("${contact.tel}")
	private String tel;
	
	@Value("${contact.email}")
	private String email;

	@Value("${contact.web}")
	private String web;
	
	@Override
	public String toString() {
		return String.format("tel: %s, email: %s, web: %s", tel, email, web );
	}
}