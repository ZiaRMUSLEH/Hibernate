package HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
    public static void main (String[] args) {

        Student01 student1 = new Student01();
        student1.setId(1001L);
        student1.setName("Jace");
        student1.setGrade(90);

        Student01 student2 = new Student01();
        student2.setId(1002L);
        student2.setName("John");
        student2.setGrade(90);

        Student01 student3 = new Student01();
        student3.setId(1003L);
        student3.setName("Mark");
        student3.setGrade(90);

        Student01 student4= new Student01();
        student4.setId(1004L);
        student4.setName("Mike");
        student4.setGrade(90);

        Student01 student5 = new Student01();
        student5.setId(1005L);
        student5.setName("Brad");
        student5.setGrade(90);

        Book01 book1 = new Book01();
        book1.setId(101L);
        book1.setName("Math");

        Book01 book2 = new Book01();
        book2.setId(102L);
        book2.setName("Physics");

        Book01 book3 = new Book01();
        book3.setId(103L);
        book3.setName("Java");

        Book01 book4 = new Book01();
        book4.setId(104L);
        book4.setName("Chemistry");

        Book01 book5 = new Book01();
        book5.setId(105L);
        book5.setName("Java");

        book1.getStudentList().add(student4);
        book2.getStudentList().add(student3);

        book3.getStudentList().add(student4);
        book4.getStudentList().add(student2);

        book5.getStudentList().add(student1);
        book1.getStudentList().add(student5);





        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class).addAnnotatedClass(Book01.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();



        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(student5);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);





        tx.commit();
        session.close();
        sf.close();


    }
}
