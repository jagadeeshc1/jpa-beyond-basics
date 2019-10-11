package com.jc.springjpademo;

import com.jc.springjpademo.entity.Course;
import com.jc.springjpademo.entity.Passport;
import com.jc.springjpademo.repository.CourseRepository;
import com.jc.springjpademo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {

	Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository repository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EntityManager entityManager;
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*logger.info("findById 101 - {}",repository.findById(101));
		repository.deleteById(101);
		Course course =new Course("New Spring framework");
		repository.save(course);
		//course.setId(1);
		System.out.println(course.getId());
		course.setName("Microservices");
		repository.save(course);

		repository.misc();*/

		//logger.info("student - {}",studentRepository.findById(201));
		Passport passport = entityManager.find(Passport.class,301l);
		logger.info("passport - {}",passport);
		logger.info("Student - {}",passport.getStudent());


	}
}
