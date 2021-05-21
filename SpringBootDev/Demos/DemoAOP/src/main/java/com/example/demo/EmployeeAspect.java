package com.example.demo;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspect {

	Logger logger = LoggerFactory.getLogger(EmployeeAspect.class);
	@After("execution(* EmployeeService.manageHolidays())")
	public void applyThisConcern(JoinPoint jp) {
		logger.debug("apply this concern");
		logger.debug("name {}", jp.getSignature().getName());
		logger.debug("modifier  {}", jp.getSignature().getModifiers());
		logger.debug("modifier  {}", jp.getSourceLocation());
			
	}
}
