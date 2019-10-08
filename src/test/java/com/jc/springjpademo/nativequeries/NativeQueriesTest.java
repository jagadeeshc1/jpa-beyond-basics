package com.jc.springjpademo.nativequeries;

import com.jc.springjpademo.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NativeQueriesTest {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public  void nativeQueries_simple(){
        Query nativeQuery = em.createNativeQuery("select * from course", Course.class);
        List list = nativeQuery.getResultList();
        logger.info("list - {}",list);
    }

    @Test
    public void nativeQueries_parameter(){
        Query nativeQuery = em.createNativeQuery("select * from course where name like ?", Course.class);
        nativeQuery.setParameter(1,"%Spring%");
        List list = nativeQuery.getResultList();
    }
    @Test
    public void nativeQueries_named_parameter(){
        Query nativeQuery = em.createNativeQuery("select * from course where name like :name", Course.class);
        nativeQuery.setParameter("name","%Spring%");
        List list = nativeQuery.getResultList();
    }

    @Test
    @Transactional//this is required because we are executing update/insert
    public void nativeQueries_update(){
        Query nativeQuery = em.createNativeQuery("update course set last_updated_date = sysdate()",
                Course.class);//with jpa we can't do batch update (?have to explore this)
        int noOfRowsUpdated = nativeQuery.executeUpdate();//for updates
        logger.info("rows updated - {}",noOfRowsUpdated);

    }

}
