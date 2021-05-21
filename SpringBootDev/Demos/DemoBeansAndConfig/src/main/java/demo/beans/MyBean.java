package demo.beans;

import org.springframework.stereotype.Component;

@Component
public class MyBean {

	@Override
	public String toString() {
		return "Hello from MyBean";
	}
}