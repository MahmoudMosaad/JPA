package com.example.demo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;

@Repository
public class CourseJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Course> findAll() {
		return jdbcTemplate.query("SELECT * FROM PERSON",
				new BeanPropertyRowMapper<Course>(Course.class));
	}

	public Course findById(int id) {

		return jdbcTemplate.queryForObject("SELECT * FROM PERSON where id = ?",
				new Object[] { id },
				new int[] { java.sql.Types.INTEGER }, 
				new BeanPropertyRowMapper<Course>(Course.class));
	}

	public int insertNewPerson(Course p) {

		return jdbcTemplate.update(" INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )" + 
		" VALUES(?, ?, ?,?)",
				new Object[] { p.getId(), p.getName()});
	}
	
	public int update(Course p) {

		return jdbcTemplate.update(" update person set "
				+ "name = ? ,location = ? ,birth_date = ? where id = ?",
				new Object[] { p.getId(), p.getName()});
	}

	public int delete(int id) {

		return jdbcTemplate.update(" delete from person where id = ? ",
				new Object[] { id });
	}

}
