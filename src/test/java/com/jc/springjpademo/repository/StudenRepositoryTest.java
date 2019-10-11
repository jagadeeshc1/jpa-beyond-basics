package com.jc.springjpademo.repository;

import com.jc.springjpademo.entity.Passport;
import com.jc.springjpademo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudenRepositoryTest {

    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    //@Transactional
    public void findPassportWithStudent(){
       Student student = studentRepository.findById(201);
       logger.info("student - {}",student);
       logger.info("passport - {}",student.getPassport());//will get exception at this point if fetchTyp=LAZY
       //to get this either make fetchType=EAGER or put @Transactional above this method

    }

    @Test
    public void findStudentWithPassport(){
        //getting data through entity manager because passport repository is not created

        Passport passport = entityManager.find(Passport.class,301l);
        logger.info("passport - {}",passport);
        logger.info("Student - {}",passport.getStudent());
    }
}
