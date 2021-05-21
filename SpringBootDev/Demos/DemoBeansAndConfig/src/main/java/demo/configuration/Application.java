package demo.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		demoSimpleJavaConfig(ctx);
		demoAdvancedJavaConfig(ctx);
		demoInjections(ctx);
	}

	private static void demoSimpleJavaConfig(ApplicationContext ctx) {
		MyBean bean = ctx.getBean(MyBean.class);
        System.out.println(bean);        
	}
	
	private static void demoAdvancedJavaConfig(ApplicationContext ctx) {

		// Lookup 1st bean via its name.
		System.out.println("1st bean:");
		SimpleService refBean1 = ctx.getBean("cool-bean", SimpleService.class);
		refBean1.doSomething();

		// Lookup 2nd bean via its various aliases.
		System.out.println("\n2nd bean (default scope, i.e. singleton):");
		SimpleService refBean2a = ctx.getBean("subsystemA-bean", SimpleService.class);
		SimpleService refBean2b = ctx.getBean("subsystemB-bean", SimpleService.class);
		SimpleService refBean2c = ctx.getBean("subsystemC-bean", SimpleService.class);
		refBean2a.doSomething();
		refBean2b.doSomething();
		refBean2c.doSomething();

		// Lookup 3rd bean (prototype-scope).
		System.out.println("\n3rd bean (prototype scope):");
		SimpleService refBean3a = ctx.getBean("proto-bean", SimpleService.class);
		SimpleService refBean3b = ctx.getBean("proto-bean", SimpleService.class);
		SimpleService refBean3c = ctx.getBean("proto-bean", SimpleService.class);
		refBean3a.doSomething();
		refBean3b.doSomething();
		refBean3c.doSomething();
	}
	
	private static void demoInjections(ApplicationContext ctx) {

		// Get BankService bean (which has a dependency on a repository bean).
		BankService bankServiceBean = ctx.getBean("bankservice-bean", BankService.class);
		
		bankServiceBean.depositIntoAccount(1, 1000);
		bankServiceBean.depositIntoAccount(2, 2000);
		bankServiceBean.withdrawFromAccount(1, 400);
		bankServiceBean.transferFunds(1, 2, 250);
	}
}
