package com.hb05.uni_manytoone;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class RunnerSave05 {

    public static void main (String[] args) {

        Student05 student1 = new Student05();
        student1.setId(1001l);
        student1.setName("Jace");

        Student05 student2 = new Student05();
        student2.setId(1002l);
        student2.setName("John");

        Student05 student3 = new Student05();
        student3.setId(1003l);
        student3.setName("Mark");

        University university = new University();
        university.setId(101l);
        university.setName("XYZ University");

        student1.setUniversity(university);
        student2.setUniversity(university);
        student3.setUniversity(university);


        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student05.class)
                .addAnnotatedClass(University.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(university);
        session.save(student1);
        session.save(student2);
        session.save(student3);


        tx.commit();
        session.close();
        sf.close();




    }
}
