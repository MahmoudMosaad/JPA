package com.example.demo.employee;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {
	
	private int hourlyWage ;

	public PartTimeEmployee() {
	}
	
	public PartTimeEmployee(String name, int hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	public int getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(int hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	@Override
	public String toString() {
		return String.format("PartTimeEmployee [hourlyWage=%s]", hourlyWage);
	}
	
	

}
