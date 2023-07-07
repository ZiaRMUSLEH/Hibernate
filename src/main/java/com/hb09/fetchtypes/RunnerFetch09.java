package com.hb09.fetchtypes;

import com.hb08.manytomany.Student08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main (String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();



        Student09 student1 = session.get(Student09.class,1001L);
        System.out.println(student1);


        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
