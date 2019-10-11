package com.jc.springjpademo.entity;

import javax.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue
    long id;
    @Column(nullable = false)
    String number;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "passport" )
    Student student;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
