package com.example.mybeansdemo;

import com.example.mybeansdemo.component.BankComponent;
import com.example.mybeansdemo.service.BankAccountsService;
import com.example.mybeansdemo.service.ISAAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class MybeansdemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(MybeansdemoApplication.class, args);

		BankComponent bc1 = context.getBean(BankComponent.class);
		bc1.deposit(100.00, "savings");
		log.info("hashcode bc1 {}", bc1.hashCode());

		BankComponent bc2 = context.getBean(BankComponent.class);
		bc2.deposit(200.00, "CURRENT");
		log.info("hashcode bc2 {}", bc2.hashCode());
		bc2.printArguments();


		ISAAccountService service = (ISAAccountService) context.getBean("isa");
		service.deposit(300.00);
		service.printArguments();
	}

}
