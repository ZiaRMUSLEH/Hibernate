package com.hb09.fetchtypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student09")
public class Student09 {

    /*

            1. If the next side is Many, then the default Type is LAZY.
                    OneToMany
                    ManyToMany
            2. If the next side is One, then the default Type is EAGER.
                    ManyToOne
                    OneToOne

     */

    @Id
    private Long id;

    @Column(name = "stu_name", nullable = false)
    private String name;

    private int grade;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)     // CascadeType.REMOVE / CascadeType.PERSIST
    private List<Book09> bookList = new ArrayList<>();

    // Getter - Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Book09> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book09> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}