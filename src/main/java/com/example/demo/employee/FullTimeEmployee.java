package com.example.demo.employee;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee{
	
	private int salary;

	public FullTimeEmployee() {
	}
	
	public FullTimeEmployee(String name, int salary) {
		super(name);
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return String.format("FullTimeEmployee [salary=%s]", salary);
	}
	
	
	

}
