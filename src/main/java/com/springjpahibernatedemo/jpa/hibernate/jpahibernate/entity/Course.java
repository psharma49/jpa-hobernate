package com.springjpahibernatedemo.jpa.hibernate.jpahibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course") 
public class Course {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@Override
	public String toString() {
		return "Course [" + name + "]";
	}

	//Default constructor is always necessary 
	protected Course() {};

	public Course(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}