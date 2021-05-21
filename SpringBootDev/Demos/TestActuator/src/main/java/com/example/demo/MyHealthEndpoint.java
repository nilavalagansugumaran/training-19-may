package com.example.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;


@Component
@Endpoint(id = "newHealth")
public class MyHealthEndpoint {
	
	 private Map<String, String> features = new ConcurrentHashMap<>();
	 
	  @ReadOperation
	    public Map<String, String> features() {
	        return features;
	    }
	 
	    @ReadOperation
	    public String feature(@Selector String name) {
	        return features.get(name);
	    }
	    
	    @WriteOperation
	    public void configureFeature(@Selector String name, String feature) {
	        features.put(name, feature);
	    }
	    @DeleteOperation
	    public void deleteFeature(@Selector String name) {
	        features.remove(name);
	    }
	    
	    @PostConstruct
	    public void afterInit() {
	    	features.put("1", "One");
	    	features.put("2", "Two");
	    	features.put("3", "Three");
	    	features.put("4", "Four");
	    		    	
	    }
}
