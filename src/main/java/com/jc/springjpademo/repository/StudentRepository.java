package com.jc.springjpademo.repository;

import com.jc.springjpademo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {


    @Autowired
    EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public Student findById(long id){
        return em.find(Student.class,id);
    }

    public void deleteById(long id){
        Student student = findById(id);
        em.remove(student);
    }

    public void save(Student student){
        if(findById(student.getId()) == null){
            em.persist(student);// persist can only be used for insert but not update
            student.setName("Persisted Student");//this will be updated in  database
        }else{
            em.merge(student); //merge can be used for both insert and update but next changes to the object won't be update in db
            student.setName("Merged student 2");//this won't be updated in  database
        }
    }


}
