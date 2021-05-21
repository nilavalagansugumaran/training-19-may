package demo.springdata.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Employee {

    @Id
	private long employeeId = -1;
	
	private String name;
	private String region;
	
	@Field("salary")
	private double dosh;
	
	public Employee() {
		// Empty no-arg constructor.
	}
	
	public Employee(int employeeId, String name, double dosh, String region) {
		this.employeeId = employeeId;
		this.name = name;
		this.dosh = dosh;
		this.region = region;
	}

	public long getEmployeeId() {
		return employeeId;
	}

    public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	
    public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
    public double getDosh() {
		return dosh;
	}
	
    public void setDosh(double dosh) {
		this.dosh = dosh;
	}
	
    public String getRegion() {
		return region;
	}
	
    public void setRegion(String region) {
		this.region = region;
	}
    
	@Override
	public String toString() {
		return String.format("Employee [employeeId=%s, name=%s, region=%s, dosh=%s]", employeeId, name, region, dosh);
	}
}
