package com.hb012.cashing;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity

@Cacheable // this ann. is to enable caching for a method and specify the caching configuration
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "Student12")

@Table(name = "tbl_Student12")
public class Student12 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "std_name",nullable = false)
    private String name;

    private int grade;

    //getter and setter


    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //To string method


    @Override
    public String toString() {
        return "Student12{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}