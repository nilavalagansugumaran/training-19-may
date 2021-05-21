package com.example.demo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

//@Component
public class MyHealthIndicator implements HealthIndicator {
	
	public Health health() {
		
		if(check() != 1) {
			return Health.down()
		              .withDetail("Error Code", 101).build();
		}
		return Health.up().build();
	}
	  public int check() {
	        // any logic to check health
	        return 0;
	  }
}
