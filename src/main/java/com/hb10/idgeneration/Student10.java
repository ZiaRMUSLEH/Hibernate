package com.hb10.idgeneration;

import javax.persistence.*;

/*

        GenerationType.AUTO:        Hibernate decides which strategy to use.

        GenerationType.SEQUENCE:    Letting developer configure stuff about ID settings     --> Oracle & PostgreSQL

        GenerationType.IDENTITY:    DB controls the ID settings     -->     1,2,3,4,----    --> MySQL

        GenerationType.TABLE:       Slowest one. Not really recommended.
        -->Creates a new table to store the id's, and fetches the ID information from there, when needed

 */

@Entity
@Table(name = "t_student10")
public class Student10 {

    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "sequence",              // Should match with the generator name
            sequenceName = "student_id",    // The sequence that'll be stored in DB
            initialValue = 1001,            // Starting number      (Optional)
            allocationSize = 10             // Allocating spaces for the ID's inside the cache.     (Optional)
    )
    private Long id;

    @Column(name = "stu_name", nullable = false, unique = false, length = 50)
    private String name;

    private int grade;

    // Getter - Setter
    public Long getId() {
        return id;
    }

    //public void setId(Long id) {
    //    this.id = id;
    //}

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

    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}