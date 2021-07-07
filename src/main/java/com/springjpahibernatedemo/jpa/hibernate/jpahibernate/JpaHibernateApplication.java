package com.springjpahibernatedemo.jpa.hibernate.jpahibernate;



//import javax.transaction.Transactional;

import org.slf4j.Logger;
//import javax.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.springjpahibernatedemo.jpa.hibernate.jpahibernate.entity.Course;
import com.springjpahibernatedemo.jpa.hibernate.jpahibernate.repository.CourseRepository;


//For delete update insert we have to add transactiona;

@SpringBootApplication
@Transactional
public class JpaHibernateApplication implements CommandLineRunner{

	private Logger logger  = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = repository.findById(10001);	
		logger.info("Course details of 10001 -> {}",course);
		
		//So delete is kind of a transaction as we are modifying the relation or make a change in data so we have to do this under transaction
		//so we will add @Transactional annotaion
//		repository.deleteById(10001);
		
		repository.save(new Course("Microservices in 100 steps"));
	}

}



