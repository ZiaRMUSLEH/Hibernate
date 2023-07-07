package HQL;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student01 {
    @Id
    private Long id;

    private String name;

    private int grade;

    public Student01 (Long id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
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

    public Student01 () {
    }

    @Override
    public String toString () {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
