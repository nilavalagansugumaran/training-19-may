package demo.additionaltechniques;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Profile("development")
public class MyBean3Dev implements MyBean3 {

	@Override
	public String toString() {
		return "Hello from MyBean3Dev";
	}
}