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
    //some methods on entityManager
    public void misc(){
        Course course1=new Course("Machine Learning");
        em.persist(course1);
        course1.setName("Machine Learning updated");
        em.flush();//push the changes so far ..to database ..can be done frequently
        Course course=new Course("Javascript");
        em.persist(course);
        em.flush();//if this flush is not there ..there is no guarantee that 'Javascript' course will be inserted
                    //since below line is detach ..so I think using flush is good practive before detach
        em.detach(course);//goes from persistent to detached state
        course.setName("JS updated");//this won't be pushed to db
        em.detach(course1);
        em.clear();//this can be done to detach all objects so far

        Course course2=new Course("Artificial Intelligence");
        em.persist(course2);
        em.flush();

        course2.setName("corrupt data");
        em.refresh(course2);//this needs to be done only after flush(i.e. course2 should be in db)..
            // else data won't be there in db and error will occur while refreshing
            //course2 will refreshed with what is in the db ..the above 'corrupt data' will be lost
        em.flush();
    }
}
