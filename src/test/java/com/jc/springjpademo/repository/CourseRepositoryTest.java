package com.jc.springjpademo.repository;

import com.jc.springjpademo.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {

	@Autowired
	CourseRepository repository;


	@Test
	public void findByIdTest(){
		Course course =new Course(102,"Spring");//this is already there in db
		assertEquals(course,repository.findById(102));
	}

	@Test
	@DirtiesContext //spring will reset the deleted data
	public void deleteByIdTest(){
		repository.deleteById(102);
		assertNull(repository.findById(102));
	}

	@Test
	@DirtiesContext
	public void insertTest(){
		Course course=new Course();
		course.setName("Spring");
		repository.save(course);
	}

	@Test
	@DirtiesContext
	public  void updateTest(){
		Course course=new Course();
		course.setName("Spring Beginner");
		repository.save(course);//first inserting
		assertNotNull(repository.findById(course.getId()));//id will be set by hibernate
		course.setName("Spring Advanced");
		repository.save(course);//this will update name -> Spring Advanced
		assertEquals("Spring Advanced",repository.findById(course.getId()).getName());
	}

}
