package com.jc.springjpademo.jpql;

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
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPQLTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;

	@Test
	public void jpql_simple(){
		Query query = em.createQuery("select c from Course c");
		List list = query.getResultList();
		logger.info("list - {}"+ list);
	}

	@Test
	public  void jpql_typed_query(){
		TypedQuery<Course> typedQuery = em.createQuery("select c from Course c", Course.class);
		List<Course> courses = typedQuery.getResultList();
		logger.info("list l - {}",courses);

	}

	@Test
	public void jpql_where_clause(){
		TypedQuery<Course> typedQuery = em.createQuery("select c from Course c where name like '%Spring%'",
				Course.class);
		List<Course> courses = typedQuery.getResultList();
		logger.info(" list l - {}",courses);

	}


	@Test
	public  void jpql_named_query(){
		TypedQuery<Course> courses = em.createNamedQuery("query_find_all_courses", Course.class);
		logger.info("courses - {}",courses);

	}

	@Test
	public  void jpql_named_query_where_clause(){
		TypedQuery<Course> courses = em.createNamedQuery("query_find_courses_with_spring", Course.class);
		logger.info("course - {}",courses);
	}


}
