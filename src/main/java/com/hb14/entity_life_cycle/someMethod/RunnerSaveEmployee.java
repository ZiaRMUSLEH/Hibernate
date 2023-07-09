package com.hb14.entity_life_cycle.someMethod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSaveEmployee {

    public static void main(String[] args) {

        Employee employee1= new Employee();

        employee1.setName("Tom HANKS");
        employee1.setSalary(9000.0);


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(employee1);





        tx.commit();
        session.close();
        sf.close();
    }
}