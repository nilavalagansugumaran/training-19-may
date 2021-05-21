package com.example.demo;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Component
public class EmployeeService {

	Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	public void manageHolidays() {
		
		logger.debug("Hello i am going to manage your holidays");
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			
		}
	}
}
