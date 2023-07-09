package com.hb012.cashing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave12 {

    public static void main(String[] args) {


        //create object

        Student12 student1= new Student12();
        student1.setName("Ali");
        student1.setGrade(95);

        Student12 student2= new Student12();
        student2.setName("Serhan");
        student2.setGrade(98);

        Student12 student3= new Student12();
        student3.setName("Zia");
        student3.setGrade(90);




        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);


        tx.commit();
        session.close();
        sf.close();


    }
}