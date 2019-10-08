package com.jc.springjpademo;

import com.jc.springjpademo.entity.Course;
import com.jc.springjpademo.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {

	Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("findById 101 - {}",repository.findById(101));
		repository.deleteById(101);
		Course course =new Course("New Spring framework");
		repository.save(course);
		//course.setId(1);
		System.out.println(course.getId());
		course.setName("Microservices");
		repository.save(course);

		repository.misc();
	}
}
