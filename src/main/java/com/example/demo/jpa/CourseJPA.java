package com.example.demo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Review;

@Repository
@Transactional
public class CourseJPA {

	@PersistenceContext
	EntityManager entity;

	public List<Course> findAll() {

		TypedQuery<Course> createNamedQuery = entity.createNamedQuery("FIND_ALL_Courses", Course.class);
		return createNamedQuery.getResultList();
	}

	public Course findById(int id) {

		return entity.find(Course.class, id);
	}

//	public Person update(Person p) {
//
//		return entity.merge(p);
//	}
//	
//	public Person insert(Person p) {
//
//		return entity.merge(p);
//	}

	public void deleteById(int id) {
		Course p = findById(id);
		entity.remove(p);
	}

	public Course save(Course p) {

		if (String.valueOf(p.getId()).equals(null) ) {
			entity.persist(p);
		} else {
			entity.merge(p);
		}
		return p;
	}
	
	public void addReviewForCourses(int courseId, List<Review> reviews) {
		Course course = findById(courseId);
		for(Review review : reviews)
		{

			course.addReview(review);
			review.setCourse(course);
			entity.persist(review);
		}
	}

}
