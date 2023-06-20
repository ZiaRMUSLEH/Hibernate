package com.hb01.annotations;

import javax.persistence.*;

@Entity // With Entity, we are creating a table in our database.
@Table(name = "t_student01")
public class Student01 {

    @Id // Defining a Primary Key - Necessary.
    private int id;

    @Column(name = "student_name", length = 50, nullable = false, unique = false) // - Optional
    private String name;

    //@Transient  // Making it not appear on the DB, as a column.
    private int grade;

    //@Lob    // Holds large data
    //private byte[] image;

    // Consturctor
    public Student01() {

    }

    // Getter - Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}