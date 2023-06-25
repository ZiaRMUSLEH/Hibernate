package com.hb05.uni_manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_student05")
public class Student05 {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "univ_id")
    private University university;

    private LocalDateTime registerDate;

    @PrePersist     // Run this method, the time you send this to the DB.
    public void prePersist(){
        registerDate = LocalDateTime.now();
    }


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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }



    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", university=" + university +
                ", registerDate=" + registerDate +
                '}';
    }
}