package com.hb11.criteriaapi;

import com.hb10.idgeneration.Student10;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave11 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student11.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Random random = new Random();

        // Create 20 students, which got the name like: Student1, Student2,etc.     &&      Have their grades random, the limit is 100.
        for (int i=1; i<21; i++){
            /*
            Student11 student = new Student11();
            student.setName("Student "+i);
            student.setGrade(random.nextInt(100));
            session.save(student);
             */

            // 2nd Way
            /*
            Student11 student1 = new Student11("Student "+i, random.nextInt(100));
            session.save(student1);
             */

            // 3rd Way
            session.save(new Student11("Student "+i, random.nextInt(100)));
        }

        tx.commit();
        session.close();
        sessionFactory.close();

    }
}