package com.springjpahibernatedemo.jpa.hibernate.jpahibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.springjpahibernatedemo.jpa.hibernate.jpahibernate.JpaHibernateApplication;
import com.springjpahibernatedemo.jpa.hibernate.jpahibernate.entity.Course;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateApplication.class)
@Transactional
class CourseRepositoryTest {
	
	
	@Autowired
	CourseRepository repository;
	
	@Test
	void findById_basic() {
		Course course = repository.findById(10001);
		assertEquals("JPA in 100 steps",course.getName());
	}
	
	@Test
	@DirtiesContext   // As deleteById changes the data in the table so we want to restore the data after the test has been done so use this annotation
	void deleteById_basic() {
		repository.deleteById(10002);
		assertNull(repository.findById(10002));
	}
	
	@Test
    @DirtiesContext
	void save_basic()
	{
		//we're testing for update
		Course course = repository.findById(10001);
		assertEquals("JPA in 100 steps",course.getName());
		
		course.setName("JPA in 100 steps - Updated");
		repository.save(course);
		Course course1 = repository.findById(10001);
		assertEquals("JPA in 100 steps - Updated",course1.getName());
		
	}
	
	

}
