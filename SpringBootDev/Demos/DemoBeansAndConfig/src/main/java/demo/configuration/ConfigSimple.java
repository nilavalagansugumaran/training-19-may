package demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSimple {

	@Bean
	public MyBean myBean() {
		return new MyBean();
	}
}
