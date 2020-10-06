package com.example.demo.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.SpringBootDataBaseDemoApplication;
import com.example.demo.entity.Course;

@SpringBootTest(classes = SpringBootDataBaseDemoApplication.class)
class CriteriaTest {
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
     EntityManager em;
	
	@Test
	void findAllTest() {
		//List<?> resultList = em.createQuery("Select c From Course c").getResultList();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> courseRoot = cq.from(Course.class);
		TypedQuery<Course> createCeiteriaQuery = em.createQuery(cq.select(courseRoot));
		List<Course> result = createCeiteriaQuery.getResultList();
		logger.info("Select c From Course c -> {}" , result);
		
		
//		TypedQuery<Course> createQuery = em.createQuery("Select c From Course c",Course.class);
//		List<Course> resultList = createQuery
//				.getResultList();
//		logger.info("Select c From Course c -> {}" , resultList);
	}
}
