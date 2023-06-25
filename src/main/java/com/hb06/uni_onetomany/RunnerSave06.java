package com.hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave06 {
    public static void main(String[] args) {

        // Students
        Student06 student1 = new Student06();
        student1.setId(1001L);
        student1.setName("Jace");
        student1.setGrade(90);

        Student06 student2 = new Student06();
        student2.setId(1002L);
        student2.setName("John");
        student2.setGrade(90);

        Student06 student3 = new Student06();
        student3.setId(1003L);
        student3.setName("Mark");
        student3.setGrade(90);

        //Books
        Book book1 = new Book();
        book1.setId(101L);
        book1.setName("Math Book");

        Book book2 = new Book();
        book2.setId(102L);
        book2.setName("Hibernate Book");

        Book book3 = new Book();
        book3.setId(103L);
        book3.setName("Java Book");

        // 1st Way
        /*
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);

        student1.setBookList(bookList);
        */

        // 2nd Way
        student1.getBookList().add(book1);
        student1.getBookList().add(book2);

        student2.getBookList().add(book3);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student06.class).addAnnotatedClass(Book.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(book1);
        session.save(book2);
        session.save(book3);

        tx.commit();
        session.close();
        sessionFactory.close();

    }
}