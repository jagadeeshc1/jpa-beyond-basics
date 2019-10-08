package com.jc.springjpademo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
//@Table(name = "Coursedetails") -> this will create table coursedetails
//@Table(name = "CourseDetails") // -> this will craete table course_details ..default spring jpa naming strategy

@NamedQuery(name = "query_find_all_courses",query = "select c from Course c")
@NamedQuery(name = "query_find_courses_with_spring", query="select c from Course c where name like '%Spring%'")
public class Course {

    @Id
    @GeneratedValue
    private long id;
    //@Column(name = "fullname",nullable = false)
    @Column(nullable = false)
    private String name;

    @CreationTimestamp
    private LocalDateTime created_date;

    @UpdateTimestamp
    private LocalDateTime last_updated_date;

    public Course() {
    }

    public Course(String name) {
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Course(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
