package com.example.demo.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Passport;
import com.example.demo.entity.Student;

@Repository
@Transactional
public class StudentJPA {

	@PersistenceContext
	EntityManager entity;

//	public List<Student> findAll() {
//
//		TypedQuery<Student> createNamedQuery = entity.createNamedQuery("FIND_ALL_Students", 
//	                        Student.class);
//		return createNamedQuery.getResultList();
//	}

	public Student findById(int id) {

		return entity.find(Student.class, id);
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
		Student s = findById(id);
		entity.remove(s);
	}

	public Student save(Student s) {

		if (String.valueOf(s.getId()).equals(null) ) {
			entity.persist(s);
		} else {
			entity.merge(s);
		}
		return s;
	}

	public Student saveWithPassport() {

		Passport pass = new Passport("Z123459");
		entity.persist(pass);
		
		Student s = new Student("mahmoud");
		s.setPassport(pass);
		entity.persist(s);
		
		return s;
	}

}
