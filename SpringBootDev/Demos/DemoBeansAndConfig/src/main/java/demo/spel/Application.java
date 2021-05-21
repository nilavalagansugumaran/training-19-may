package demo.spel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		SpelBean bean = ctx.getBean(SpelBean.class);
		
		bean.displayScalarValues();
		bean.displayCollectionIndexing();
		bean.displayCollectionSelectionProjection();
		bean.displayUserName();
	}

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
