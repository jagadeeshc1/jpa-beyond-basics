package com.jc.springjpademo.entity;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    long id;
    @Column(nullable = false)
    String rating;
    String description;

    @OneToOne(fetch = FetchType.LAZY)
    Course course;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
