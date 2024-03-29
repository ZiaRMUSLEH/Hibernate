package HQL;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student01 {
    @Id
    private Long id;

    private String name;

    private int grade;






    @ManyToMany(mappedBy = "studentList")
    private List<Book01> bookList = new ArrayList<>();










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

    public List<Book01> getBookList () {
        return bookList;
    }

    public void setBookList (List<Book01> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString () {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
        // ", bookList=" + bookList +
                '}';
    }
}
