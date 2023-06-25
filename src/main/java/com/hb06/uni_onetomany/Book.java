package com.hb06.uni_onetomany;

import javax.persistence.*;

@Entity
@Table(name = "t_book06")
public class Book {

    @Id
    private Long id;

    @Column(name = "book_name", nullable = false, length = 100)
    private String name;

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

    // toString
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}