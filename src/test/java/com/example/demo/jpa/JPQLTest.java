package com.example.demo.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.SpringBootDataBaseDemoApplication;
import com.example.demo.entity.Course;

@SpringBootTest(classes = SpringBootDataBaseDemoApplication.class)
class JPQLTest {
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
     EntityManager em;
	
	@Test
	void findAllTest() {
		//List<?> resultList = em.createQuery("Select c From Course c").getResultList();
		List<Course> resultList = em.createQuery("Select c From Course c",Course.class)
				.getResultList();
		logger.info("Select c From Course c -> {}" , resultList);
	}
	
	@Test
	void selectOneTest() {
		//List<?> resultList = em.createQuery("Select p From Person p").getResultList();
		TypedQuery<Course> createQuery = em.createQuery("select c from Course c where c.id = :n",
				Course.class);
		createQuery.setParameter("n", 10001);
		List<Course> resultList = createQuery
				.getResultList();
		logger.info("Select c From Course c -> {}" , resultList);
	}
	
	@Test
	void findTest() {
		//List<?> resultList = em.createQuery("Select c From Course c").getResultList();
		List<Course> resultList = em.createNamedQuery("FIND_Course",Course.class)
				.getResultList();
		logger.info("Select c From Course c -> {}" , resultList);
	}
	

	

	@Test
	public void jpql_where() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_100_Step_courses", Course.class);

		List<Course> resultList = query.getResultList();

		logger.info("Select  c  From Course c where name like '%100 Steps'-> {}", resultList);
		// [Course[Web Services in 100 Steps], Course[Spring Boot in 100 Steps]]
	}

	@Test
	public void jpql_courses_without_students() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Results -> {}", resultList);
		// [Course[Spring in 50 Steps]]
	}

	
	@Test
	public void jpql_courses_with_atleast_2_students() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students) >= 2", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Results -> {}", resultList);
		//[Course[JPA in 50 Steps]]
	}

	@Test
	public void jpql_courses_ordered_by_students() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c order by size(c.students) desc", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Results -> {}", resultList);
	}

	//like
		//BETWEEN 100 and 1000
		//IS NULL
		//upper, lower, trim, length
		
		//JOIN => Select c, s from Course c JOIN c.students s
		//LEFT JOIN => Select c, s from Course c LEFT JOIN c.students s
		//CROSS JOIN => Select c, s from Course c, Student s
		//3 and 4 =>3 * 4 = 12 Rows
		@Test
		@Transactional
		public void join(){
			Query query = em.createQuery("Select c, s from Course c JOIN c.students s");
			@SuppressWarnings("unchecked")
			List<Object[]> resultList = query.getResultList();
			logger.info("Results Size -> {}", resultList.size());
			for(Object[] result:resultList){
				logger.info("Course{} Student{}", result[0], result[1]);
			}
		}

		@Test
		public void left_join(){
			Query query = em.createQuery("Select c, s from Course c LEFT JOIN c.students s");
			@SuppressWarnings("unchecked")
			List<Object[]> resultList = query.getResultList();
			logger.info("Results Size -> {}", resultList.size());
			for(Object[] result:resultList){
				logger.info("Course{} Student{}", result[0], result[1]);
			}
		}

		@Test
		public void cross_join(){
			Query query = em.createQuery("Select c, s from Course c, Student s");
			@SuppressWarnings("unchecked")
			List<Object[]> resultList = query.getResultList();
			logger.info("Results Size -> {}", resultList.size());
			for(Object[] result:resultList){
				logger.info("Course{} Student{}", result[0], result[1]);
			}
		}

}
