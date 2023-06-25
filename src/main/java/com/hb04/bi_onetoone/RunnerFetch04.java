package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student04.class).addAnnotatedClass(Diary.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // Get Student with id: 1001 and Diary with id: 101.
        Student04 student1 = session.get(Student04.class, 1001L);
        System.out.println(student1);
        System.out.println("*********************\n");
        Diary diary1 = session.get(Diary.class, 101L);
        System.out.println(diary1);
        System.out.println("\n******** Get the Diary Object From Student ********");
        System.out.println(student1.getDiary());
        System.out.println("\n******** Get the Student Object From Diary ********");
        System.out.println(diary1.getStudent());
        System.out.println("\n******** Get the Student Name Through the Diary ********");
        System.out.println(diary1.getStudent().getName());

        System.out.println("\n******** INNER JOIN ********");
        // To access to the second table with HQL, we are adding the word FETCH

        // Get the Student Name and Diary Name with HQL. (by using INNER JOIN)
        String hql1 = "SELECT s.name, d.name FROM Student04 s INNER JOIN FETCH Diary d ON s.id = d.student.id";
        //String sql1 = "SELECT s.name, d.name FROM t_student04 s INNER JOIN t_diary1 d ON s.id = d.stu_id";
        List<Object[]> resultList1 = session.createQuery(hql1).getResultList();

        for (Object[] objArr : resultList1){
            System.out.println(Arrays.toString(objArr));
        }
        //resultList1.forEach(obj -> System.out.println(Arrays.toString(obj)));

        System.out.println("\n******** LEFT JOIN ********");
        // Get the Student Name and Diary Name with HQL. (by using LEFT JOIN)
        String hql2 = "SELECT s.name, d.name FROM Student04 s LEFT JOIN FETCH Diary d ON s.id = d.student.id";
        List<Object[]> resultList2 = session.createQuery(hql2).getResultList();
        resultList2.forEach(obj -> System.out.println(Arrays.toString(obj)));

        System.out.println("\n******** RIGHT JOIN ********");
        String hql3 = "SELECT s.name, d.name FROM Student04 s RIGHT JOIN FETCH Diary d ON s.id = d.student.id";
        List<Object[]> resultList3 = session.createQuery(hql3).getResultList();
        resultList3.forEach(obj -> System.out.println(Arrays.toString(obj)));

        System.out.println("\n******** FULL JOIN ********");
        // Get the Student Name and Diary Name with HQL.
        String hql4 = "SELECT s.name, d.name FROM Student04 s FULL JOIN FETCH Diary d ON s.id = d.student.id";
        List<Object[]> resultList4 = session.createQuery(hql4).getResultList();
        resultList4.forEach(obj -> System.out.println(Arrays.toString(obj)));

        tx.commit();
        session.close();
        sessionFactory.close();

    }
}