package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {

        // Students
        Student07 student1 = new Student07();
        student1.setId(1001L);
        student1.setName("Jace");
        student1.setGrade(90);

        Student07 student2 = new Student07(1002L, "John", 90);


        // Books
        Book07 book1 = new Book07();
        book1.setId(101L);
        book1.setName("Math Book");
        book1.setStudent(student1);

        Book07 book2 = new Book07();
        book2.setId(102L);
        book2.setName("Chemistry Book");
        book2.setStudent(student1);

        Book07 book3 = new Book07();
        book3.setId(103L);
        book3.setName("Java Book");
        book3.setStudent(student2);

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student07.class)
                .addAnnotatedClass(Book07.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);

        session.save(book1);
        session.save(book2);
        session.save(book3);

        tx.commit();
        session.close();
        sessionFactory.close();



    }
}