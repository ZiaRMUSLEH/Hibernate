package com.hb04.bi_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_student04")
public class Student04 {

    @Id
    private Long id;

    private String name;

    private int grade;

    @OneToOne(mappedBy = "student")     // mappedBy: will not create any column for the diary id.
    private Diary diary;

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

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    // toString
    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name +
                ", grade=" + grade +
               // ", diary=" + diary +
                '}';
    }
}