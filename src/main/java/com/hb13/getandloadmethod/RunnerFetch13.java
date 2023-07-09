package com.hb13.getandloadmethod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch13 {

    public static void main(String[] args) {


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


//        System.out.println("************* get method start ****************");
//
//        Student13 student1 = session.get(Student13.class,1L);
//
//        System.out.println("************* get method end ****************");
//
//        System.out.println(student1.getId());
//        System.out.println(student1.getName());


//        System.out.println("************* load method start ****************");
//        Student13 student2 = session.load(Student13.class,1L);
//        System.out.println("************* load method end ****************");
//        System.out.println("get Id " + student2.getId());
//        System.out.println("get Name : " + student2.getName());


//        System.out.println("************* get  method start  for data does not exist in DB****************");
//
//         Student13 student3  = session.get(Student13.class,4L);
//
//        System.out.println("Students with id is : "+student3);
//
//        if (student3!=null){
//            System.out.println(student3.getName());
//        }
//        //System.out.println(student3.getGrade());//NullPointerException
//
//        System.out.println("get method is end ..");



        System.out.println("************* load  method start  for data does not exist in DB****************");

        Student13 student4=  session.load(Student13.class,4L);//return fake / proxy object
        System.out.println("Student with id : " +student4);// rerun ObjectNotFoundException

        if (student4!=null){
            System.out.println(student4.getName());//// rerun ObjectNotFoundException
        }
        System.out.println("Load  method is end ..");

        //!!! Where we should  use load () ?


        /*
        //if you are sure that obj is in your DB, and if you are not going to use any field (lazy loading),
        // then you can use load method. because it will not fetch data from database, and you will save some time


         */



        tx.commit();
        session.close();
        sf.close();
    }
}