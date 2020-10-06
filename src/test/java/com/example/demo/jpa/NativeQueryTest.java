package com.example.demo.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.SpringBootDataBaseDemoApplication;
import com.example.demo.entity.Course;

@SpringBootTest(classes = SpringBootDataBaseDemoApplication.class)
class NativeQueryTest {
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
     EntityManager em;
	 
	@Test
	void nativeQueryTest() {
		//List<?> resultList = em.createQuery("Select p From Person p").getResultList();
		Query createNativeQuery = em.createNativeQuery("select * from course where id = ?",
				Course.class);
		createNativeQuery.setParameter(1, 10001);
		List<?> resultList = createNativeQuery.getResultList();
		logger.info("Select p From Person p -> {}" , resultList);
	}

	

}
