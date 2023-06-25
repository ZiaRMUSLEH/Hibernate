package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {

        // Creating the Students
        Student04 student1 = new Student04();
        student1.setId(1001L);
        student1.setName("Jace");
        student1.setGrade(90);

        Student04 student2 = new Student04();
        student2.setId(1002L);
        student2.setName("John");
        student2.setGrade(90);

        Student04 student3 = new Student04();
        student3.setId(1003L);
        student3.setName("Mark");
        student3.setGrade(90);

        Student04 student4 = new Student04();
        student4.setId(1004L);
        student4.setName("X");
        student4.setGrade(90);

        // Creating the Diaries
        Diary diary1 = new Diary();
        diary1.setId(101L);
        diary1.setName("Jace's Diary");

        Diary diary2 = new Diary();
        diary2.setId(102L);
        diary2.setName("John's Diary");

        Diary diary3 = new Diary();
        diary3.setId(103L);
        diary3.setName("Mark's Diary");

        Diary diary4 = new Diary();
        diary4.setId(104L);
        diary4.setName("Unassigned Diary");


        // Assigning Students to Diaries
        diary1.setStudent(student1);
        diary2.setStudent(student2);
        diary3.setStudent(student3);


        // Hibernate
        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Diary.class)
                .addAnnotatedClass(Student04.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        /*
        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);
        session.save(diary3);

         */
        //session.save(student4);
        session.save(diary4);

        tx.commit();
        session.close();
        sf.close();


    }
}