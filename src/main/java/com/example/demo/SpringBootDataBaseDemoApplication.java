package com.example.demo;



//import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.employee.FullTimeEmployee;
import com.example.demo.employee.PartTimeEmployee;
import com.example.demo.jpa.CourseJPA;
import com.example.demo.jpa.EmployeeJPA;
import com.example.demo.jpa.StudentJPA;

@SpringBootApplication
public class SpringBootDataBaseDemoApplication implements CommandLineRunner {

//	@Autowired
//	PersonJdbcDao dao;

	@Autowired
	CourseJPA courseJpa;

	@Autowired
	StudentJPA studentJpa;

	@Autowired
	EmployeeJPA employeeJpa;
	
	//private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataBaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		 logger.info("All users -> {}", dao.findAll());
//		 Person p = new Student("Ranga");
//		 logger.info(" user 10001 -> {}", courseJpa.save(new Course( "restful" )));
//		 logger.info(" user 10001 -> {}", courseJpa.save(new Sudent(1,"mahmoud mosaad")));
//		 logger.info(" student 1 -> {}", studentJpa.saveWithPassport());
//		 jpa.deleteById(10001);

//		Course findById = courseJpa.findById(10001);
//		findById.setName("mahmoud");
//		findById.setName("55"+5);
//		logger.info(" user 10001 -> {}", findById);
		
//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review(ReviewRating.FIVE,"very good"));
//		reviews.add(new Review(ReviewRating.FIVE,"very very good"));
//		courseJpa.addReviewForCourses(10001, reviews);
//		logger.info(" student 1 -> {}");
		
		employeeJpa.insert(new FullTimeEmployee("mahmoud", 5000));
		employeeJpa.insert(new PartTimeEmployee("mahmoud", 50));
		employeeJpa.insert(new FullTimeEmployee("mahmoud", 50000));
		employeeJpa.insert(new PartTimeEmployee("mahmoud", 500));
		
		
//		logger.info("employees are " ,employeeJpa.findAllFullTimeEmployee() );
//		logger.info("employees are " ,employeeJpa.findAllPartTimeEmployee() );

	}

}
