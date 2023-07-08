package com.hb10.idgeneration;

import com.hb09.fetchtypes.Book09;
import com.hb09.fetchtypes.Student09;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {
    public static void main(String[] args) {

        Student10 student1 = new Student10();
        //student1.setId(1001L);
        student1.setName("Jace");
        student1.setGrade(90);

        Student10 student2 = new Student10();
        student2.setName("John");
        student2.setGrade(90);

        Student10 student3 = new Student10();
        student3.setName("Mark");
        student3.setGrade(90);

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student10.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit();
        session.close();
        sessionFactory.close();

    }
}