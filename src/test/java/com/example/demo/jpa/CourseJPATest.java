package com.example.demo.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

//import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.demo.SpringBootDataBaseDemoApplication;
import com.example.demo.entity.Course;

@SpringBootTest(classes = SpringBootDataBaseDemoApplication.class)
class CourseJPATest {
	
	 //private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
	 CourseJPA jpa;

	@Test
	void findByIdTest() {
		Course p = jpa.findById(10002);
		assertEquals("James", p.getName());
	}
	
	@Test
	@DirtiesContext
	void deletByIdTest() {
	    jpa.deleteById(10002);
		assertNull(jpa.findById(10002));
	}
	
	@Test
	@DirtiesContext
	void saveTest() {
		jpa.save(new Course("mahmoud"));
		jpa.save(new Course(1,"mahmoud mosaad"));
	    assertEquals("mahmoud mosaad", jpa.findById(1).getName());
	}

}
