package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Passport {

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String number;       
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	private Student student;
    
	public Passport() {
	}

	public Passport(int id, String number) {
		super();
		this.id = id;
		this.number = number;
	}

	public Passport(String number) {
		super();
		this.number = number;

	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return String.format("Passport [id=%s, number=%s]", id, number);
	}

}
