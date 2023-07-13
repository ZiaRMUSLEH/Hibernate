package com.hb14.entity_life_cycle.someMethod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetchEmployee {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        System.out.println("get method call");

        Employee employee1= session.get(Employee.class,1L);

        System.out.println("Delete method is called ...");

        session.delete(employee1);




        tx.commit();
        session.close();
        sf.close();
    }
}
