package com.hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student06.class).addAnnotatedClass(Book.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // Get the student with id: 1001
        Student06 student1 = session.get(Student06.class, 1001L);
        System.out.println(student1);

        // Get/Fetch the book id&name with id: 101 using HQL
        System.out.println("\n******** Get/Fetch the student's book with id: 1001 using HQL ********");
        String hql1 = "SELECT b.id, b.name FROM Student06 s INNER JOIN s.bookList b WHERE s.id=1001L";
        List<Object[]> resultList1 = session.createQuery(hql1).getResultList();
        for (Object[] objArr : resultList1){
            System.out.println(Arrays.toString(objArr));
        }

        System.out.println("\n******** Fetch the books of the student whose id is 1001. (Use the get method) ********");
        Student06 student2 = session.get(Student06.class, 1001L);
        System.out.println(student2.getBookList());

        // Another way
        List<Book> bookList = session.get(Student06.class, 1001L).getBookList();
        for (Book b : bookList)
            System.out.println(b.getName());


        tx.commit();
        session.close();
        sessionFactory.close();



    }
}