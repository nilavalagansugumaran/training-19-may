package demo.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="demo.config2.code")
public class ConfigSpel {

	@Bean 
	public List<String> cities() {
		List<String> cities = new ArrayList<>();
		cities.add("Aberdeen");
		cities.add("Aberdare");
		cities.add("Aberystwyth");
		cities.add("Birmingham");
		cities.add("Brighton");
		cities.add("Bristol");
		cities.add("Cardiff");
		cities.add("Coventry");
		cities.add("Colchester");
		cities.add("Swansea");
		return cities;
	}
	
	@Bean 
	public Map<String, String> currencies() {
		Map<String, String> currencies = new HashMap<>();
		currencies.put("UK", "GBP");
		currencies.put("Norway", "NOK");
		currencies.put("Europe", "EUR");
		return currencies;
	}
}
