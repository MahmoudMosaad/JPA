package com.example.demo.employee;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "EMPLOYEE_TYPE") //use to change name of DTYPE to EMPLOYEE_TYPE column
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) 
public abstract class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	
	public Employee() {
	}
	
	public Employee(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Employee [id=%s, name=%s]", id, name);
	}
	

}
