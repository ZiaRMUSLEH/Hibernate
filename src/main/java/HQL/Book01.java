package HQL;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book01 {
    @Id
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "stid_bookid",
            joinColumns ={@JoinColumn(name = "stu_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Student01> studentList = new ArrayList<>();

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

    public List<Student01> getStudentList () {
        return studentList;
    }

    public void setStudentList (List<Student01> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString () {
        return "Book01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
