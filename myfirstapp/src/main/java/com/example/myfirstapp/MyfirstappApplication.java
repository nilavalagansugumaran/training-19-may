package com.example.myfirstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyfirstappApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(MyfirstappApplication.class, args);

//		// Object that we created
		Accounts accounts = new Accounts("NILA");
		accounts.sayHello();

		//Object created by spring container
		Accounts springAccounts = context.getBean(Accounts.class);
		//springAccounts.setName("Andy");
		springAccounts.sayHello();

	}

}
