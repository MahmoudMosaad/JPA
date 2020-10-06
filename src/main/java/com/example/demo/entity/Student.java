package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity

public class Student {

	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	private String name;

	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE",
	joinColumns = @JoinColumn(name = "STUDENT_ID"),
	inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	private List<Course> courses = new ArrayList<>();
	
	@OneToOne(fetch = FetchType.LAZY )   // lazy mean don't fetch this data until required
	private Passport passport;         // eager mean fetch this data when fetch this object

	@Embedded
	private Address adress ;
	
	public Student() {
	}

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Student(String name) {
		super();
		this.name = name;

	}

	
	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}
	
	@Override
	public String toString() {
		return String.format("Student [id=%s, name=%s]", id, name);
	}

}
