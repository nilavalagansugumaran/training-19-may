package com.example.demoRabbitMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoRabbitMqApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DemoRabbitMqApplication.class, args);

		context.getBean(MyRabbitSender.class).sendEmpMessage(new Employee(5, "nila-5"));
		context.getBean(MyRabbitSender.class).sendEmpMessage(new Employee(6, "nila-6"));
		context.getBean(MyRabbitSender.class).sendEmpMessage(new Employee(6, "nila-7"));
	}

}
