package com.hb08.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {
    public static void main (String[] args) {

        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book08.class)
                .addAnnotatedClass(Student08.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student08 student1 = session.get(Student08.class,1001l);
        System.out.println(student1);

        Book08 book1 = session.get(Book08.class,101L);
        System.out.println(book1);




        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
