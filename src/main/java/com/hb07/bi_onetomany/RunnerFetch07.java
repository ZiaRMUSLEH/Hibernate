package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student07.class)
                .addAnnotatedClass(Book07.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // Get the student with ID: 1001, using a method.
        Student07 student1 = session.get(Student07.class, 1001L);
        //System.out.println(student1);

        // Get the books of student1.
        //List<Book07> bookList = student1.getBookList();
        //System.out.println(bookList);
        //student1.getBookList().forEach(stu-> System.out.println(stu));

        // Get the book with ID: 101
        Book07 book1 = session.get(Book07.class, 101L);
        System.out.println("Book 1: "+ book1);

        // Get the student information from the book object
        //System.out.println(book1.getStudent());

        // Fetch the assigned student name and book names, using SQL from Student
//        String sqlQuery1 = "SELECT s.stu_name, b.name FROM t_student07 s INNER JOIN t_book07 b ON s.id = b.stu_id";
//        List<Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
//        for (Object[] obj : resultList1){
//            System.out.println(Arrays.toString(obj));
//        }

        // Do the upper task with HQL
//        String hqlQuery1 = "SELECT s.name, b.name FROM Student07 s INNER JOIN Book07 b ON s.id = b.student.id";
//        List<Object[]> resultList2 = session.createQuery(hqlQuery1).getResultList();
//        for (Object[] obj : resultList2){
//            System.out.println(Arrays.toString(obj));
//        }
        //resultList2.forEach(obj-> System.out.println(obj));
        //resultList2.forEach(System.out::println);

//       //  Delete all the records from Book07 with SQL.
//        String sqlQuery2 = "DELETE FROM t_book07";
//        int deletedRowCount = session.createSQLQuery(sqlQuery2).executeUpdate();
//        System.out.println("Deleted Row Count: "+deletedRowCount);

        // Delete all the records from Student07 with HQL.
        String hqlQuery2 = "DELETE FROM Student07";
        int deletedRowCountHql = session.createQuery(hqlQuery2).executeUpdate();
        System.out.println("Deleted Row Count For HQL: "+deletedRowCountHql);

        /*

        A Book (0)      ->  Student07.getBookList().set(0, null);
        B Book (1)      ->

         */

        tx.commit();
        session.close();
        sessionFactory.close();

    }
}