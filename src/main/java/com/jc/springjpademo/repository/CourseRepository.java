package com.jc.springjpademo.repository;

import com.jc.springjpademo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {


    @Autowired
    EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public Course findById(long id){
        return em.find(Course.class,id);
    }

    public void deleteById(long id){
        Course course = findById(id);
        em.remove(course);
    }

    public void save(Course course){
        if(findById(course.getId()) == null){
            em.persist(course);// persist can only be used for insert but not update
            course.setName("Persisted Course");//this will be updated in  database
        }else{
            em.merge(course); //merge can be used for both insert and update but next changes to the object won't be update in db
            course.setName("Merged course 2");//this won't be updated in  database
        }
    }
}
