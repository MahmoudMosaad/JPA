package com.example.demo.jpa;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

//import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import com.example.demo.SpringBootDataBaseDemoApplication;
import com.example.demo.entity.Course;

@SpringBootTest(classes = SpringBootDataBaseDemoApplication.class)
class CourseSpringDataTest {
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
	 CourseSpringDataReposetory jpa;

	@Test
	void findByIdTest() {
		Optional<Course> findById = jpa.findById(20001);
		assertTrue(findById.isPresent());
	}
	
	@Test
	void findByAllTest() {
		
	    logger.info("\nsorted >>>>>>>>>",jpa.findAll());

	}
	
	@Test
	void sortTest() {
		
		Sort sort = Sort.by(Sort.Direction.DESC, "name");
		
	    logger.info("\nsorted >>>>>>>>>",jpa.findAll(sort));
		
	}
	
	@Test
	void paginationTest() {
		 
        PageRequest pageRequest = PageRequest.of(0, 3);	
	    Page<Course> firstPage = jpa.findAll(pageRequest);
		logger.info("\nsorted >>>>>>>>>",firstPage.getContent());
		
	}
	
	@Test
	void insertCourseTest() {
		Course c = new Course("hhhhhhhhhhhhh");
		jpa.save(c);
		c.setName("jjjjjjjjjjjjjjj");
		jpa.save(c);
	}
	
}
