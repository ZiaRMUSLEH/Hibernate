package com.hb14.entity_life_cycle;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {

    public static void main(String[] args) {


        Student14 student1= new Student14();//Transient state. Hibernate hos no responsibility
        student1.setName("Ismail");
        student1.setGrade(90);



        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student14.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);// persistent state ..  hibernate will track with my object

        student1.setName("Serhan2");//name will be Serhan on DB

        // session.close();;;

        session.evict(student1); //detached state ...

        student1.setName("Enes ");// //detached state obj will be taken in persistent sate.

        session.merge(student1);


        tx.commit();
        session.close();
        sf.close();

    }
}