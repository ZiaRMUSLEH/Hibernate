package com.hb08.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="t_student08")
public class Student08 {

    @Id
    private Long id;

    private String name;

    private int grade;

    @ManyToMany
    @JoinTable(name = "stuid_bookid",
            joinColumns = {@JoinColumn(name= "stu_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Book08> bookList = new ArrayList<>();

    @Override
    public String toString () {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
              //  ", bookList=" + bookList +
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

    public int getGrade () {
        return grade;
    }

    public void setGrade (int grade) {
        this.grade = grade;
    }

    public List<Book08> getBookList () {
        return bookList;
    }

    public void setBookList (List<Book08> bookList) {
        this.bookList = bookList;
    }
}
