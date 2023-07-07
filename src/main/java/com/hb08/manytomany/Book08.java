package com.hb08.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="t_book08")
public class Book08 {

    @Id
    private Long id;
    private String name;


    @ManyToMany(mappedBy = "bookList")
    private List<Student08> studentList = new ArrayList<>();

    @Override
    public String toString () {
        return "Book08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public List<Student08> getStudentList () {
        return studentList;
    }

    public void setStudentList (List<Student08> studentList) {
        this.studentList = studentList;
    }
}
