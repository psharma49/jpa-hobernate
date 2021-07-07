package com.springjpahibernatedemo.jpa.hibernate.jpahibernate.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springjpahibernatedemo.jpa.hibernate.jpahibernate.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	
	public Course findById(int id)
	{
		return em.find(Course.class, id);
	}
	
	
	
	public void deleteById(int id)
	{
		Course course = findById(id);
		em.remove(course);
	}
	
	
	public void save(Course course)
	{
		if(course.getId()==0)
		{
			//persist is used to insert course
			em.persist(course);
		}
		else
		{
			//merge to update an existing course
			em.merge(course);
		}
//		return course;
	}
	
	

}
