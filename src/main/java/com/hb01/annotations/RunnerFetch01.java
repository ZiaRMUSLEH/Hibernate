package com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {

        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        /*

                In order to fetch data from DB, there are three ways:

                1. get();
                2. SQL Query
                3. HQL Query

         */

        // get();
        /*
        Student01 student1 = session.get(Student01.class, 1);       // Data type, Primary Key Value
        Student01 student2 = session.get(Student01.class, 2);
        Student01 student3 = session.get(Student01.class, 3);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
         */

        // SQL
        /*
        String sqlQuery1 = "SELECT * FROM t_student01";

        List<Object[]> resultList = session.createSQLQuery(sqlQuery1).getResultList();

        //System.out.println(resultList);

        for (Object[] stu : resultList){
            System.out.println(Arrays.toString(stu));
        }
         */

        // HQL
        /*
        String hqlQuery1 = "FROM Student01";
        List<Student01> students = session.createQuery(hqlQuery1, Student01.class).getResultList();

        System.out.println(students);

        for (Student01 stu : students){
            //System.out.println(stu);
        }
         */

        // TASKS
        // Get the student with the name John, as a unique result in SQL.
        /*
         String sqlQuery2 = "SELECT * FROM t_student01 WHERE student_name='John'";
         Object[] stu1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
        System.out.println(Arrays.toString(stu1));
         */

        // Get the student with the name John, as a unique result in HQL. (With Aliases)
        /*
        String hqlQuery2 = "FROM Student01 s WHERE s.name='John'";
        Student01 student2 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
        System.out.println(student2);
         */

        // Get the name and id's of students whose ids are less than 3, in HQL, using aliases.
        /*
        String hqlQuery3 = "SELECT s.name, s.id FROM Student01 s WHERE s.id<3";
        List<Object[]> stuList = session.createQuery(hqlQuery3).getResultList();

        for (Object[] stu : stuList){
            System.out.println(Arrays.toString(stu));
        }
         */

        tx.commit();
        session.close();
        sessionFactory.close();

    }
}