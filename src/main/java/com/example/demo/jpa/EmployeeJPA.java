package com.example.demo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.employee.Employee;
import com.example.demo.employee.FullTimeEmployee;
import com.example.demo.employee.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeJPA {

	@PersistenceContext
	EntityManager entity;

//	public List<Employee> findAll() {
//
//		return entity.createQuery("select e from Employee e", Employee.class)
//				.getResultList();
//
//	}

	public List<PartTimeEmployee> findAllPartTimeEmployee() {

		return entity.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class)
				.getResultList();

	}
	
	public List<FullTimeEmployee> findAllFullTimeEmployee() {

		return entity.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class)
				.getResultList();

	}
	
//	public Employee findById(int id) {
//
//		return entity.find(Employee.class, id);
//	}

	public void insert(Employee e) {

		entity.persist(e);
	}

}
