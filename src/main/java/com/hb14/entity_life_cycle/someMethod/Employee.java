package com.hb14.entity_life_cycle.someMethod;


import javax.persistence.*;

@Entity
@Table(name = "tble_empolyee")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_salary")
    private Double salary;


    // some Method


    @PrePersist
    public  void OnPrePersist(){

        System.out.println("******* Before data Object being persist");
    }


    @PostPersist
    public  void OnPostPersist(){

        System.out.println("******* After  data Object being persist");
    }


    @PostLoad
    public  void OnPostLoad(){

        System.out.println("******* After  Loading data");
    }


    @PreRemove
    public  void OnPreRemove(){

        System.out.println("******* Before   data Object being remove");
    }


    @PostRemove
    public  void OnPostRemove(){

        System.out.println("******* After   data Object being remove");
    }

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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    //to String method


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}