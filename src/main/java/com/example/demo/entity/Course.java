package com.example.demo.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "FIND_ALL_Courses" ,query = "SELECT c FROM  Course c"),
                @NamedQuery(name = "query_get_all_courses_join_fetch", 
		query = "Select  c  From Course c JOIN FETCH c.students s"),
		@NamedQuery(name = "query_get_100_Step_courses" ,query = "Select  c  From Course c where name like '%100 Steps'")
})
@Cacheable
public class Course {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "course")
	private List<Review> review = new ArrayList<>();
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<>();
	
	public Course() {}
	
	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Course(String name) {
		super();
		this.name = name;
		
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



	public List<Review> getReview() {
		return review;
	}

	public void addReview(Review review) {
		this.review.add(review);
	}

	public void removeReview(Review review) {
		this.review.remove(review);
	}
	
	public List<Student> getStudentes() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	@Override
	public String toString() {
		return String.format("Course [id=%s, name=%s]", id, name);
	}


	
	

}
