package com.example.demo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private Long userId;
	
	private String name;
	
	private String dept;
	
	private Double salary;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public User(Long userId, String name, String dept, Double salary) {
		this.userId = userId;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}
	
}
