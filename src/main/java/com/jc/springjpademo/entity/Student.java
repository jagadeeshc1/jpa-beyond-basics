package com.jc.springjpademo.entity;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    long id;
    @Column(nullable = false)
    String name;

    @OneToOne(fetch = FetchType.LAZY)
    Passport passport;

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
