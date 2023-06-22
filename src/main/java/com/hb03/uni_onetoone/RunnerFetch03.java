package com.hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Diary.class)
                .addAnnotatedClass(Student03.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("**** Using .get() to fetch the Student with id 1001 ****");
        Student03 student1 = session.get(Student03.class, 1001L);
        System.out.println(student1);

        System.out.println("**** Using .get() to fetch the Diary with id 101 ****");
        Diary diary1 = session.get(Diary.class, 101L);
        System.out.println(diary1);

        System.out.println("**** Using getter to fetch the Student from Diary ****");
        System.out.println(diary1.getStudent());

        tx.commit();
        session.close();
        sessionFactory.close();

    }
}