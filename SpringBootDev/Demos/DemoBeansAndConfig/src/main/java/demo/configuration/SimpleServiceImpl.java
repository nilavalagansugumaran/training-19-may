package demo.configuration;

import java.util.Date;

public class SimpleServiceImpl implements SimpleService {

	private static int count = 0;
	private int id;
	
	public SimpleServiceImpl() {
		id = count++;
	}
	
	public void doSomething() {
		System.out.println("*****MySimpleServiceImpl (" + id + ") doing something at " + new Date());
	}
}