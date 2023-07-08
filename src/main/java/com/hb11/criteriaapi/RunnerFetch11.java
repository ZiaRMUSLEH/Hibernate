package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch11 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student11.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        /*

                CRUD (Create, Read, Update, Delete)

                C   -->     session.save(), session.persist()
                R   -->     session.get(), HQL, SQL
                U   -->     session.update(),   updateQuery
                D   -->     session.delete(),   HQL, SQL

         */

        // Update An Existing Data
        Student11 student1 = session.get(Student11.class, 1L);
        student1.setName("Updated "+student1.getName());
        session.update(student1);

        // Update An Existing Data With Query
        // Update the grades that are less than 50, to 70.

        int sGrade = 70;
        int lGrade = 50;

        String hqlQuery1 = "UPDATE Student11 s SET s.grade =: sMath WHERE s.grade<: lMath";
        Query query1 = session.createQuery(hqlQuery1);

        // Assign the Variables
        query1.setParameter("sMath", sGrade);
        query1.setParameter("lMath", lGrade);

        // Execute the Query
        int numberOfUpdatedRows = query1.executeUpdate();
        System.out.println("Updated Row Count: "+numberOfUpdatedRows);

        // Criteria API
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Student11> criteriaQuery = criteriaBuilder.createQuery(Student11.class);
        Root<Student11> root = criteriaQuery.from(Student11.class);     // FROM Student11

        // Select All Students
        String sqlQuery2 = "SELECT * FROM Student11";

        criteriaQuery.select(root);     // SELECT * FROM Student11
        Query<Student11> query2 = session.createQuery(criteriaQuery);
        List<Student11> resultList1 = query2.getResultList();
        for (Student11 stu : resultList1){
            System.out.println(stu);
        }

        // Get the studentS whose name is "Student 5"
        String sqlQuery3 = "SELECT * FROM t_student11 s WHERE s.name = 'Student 5'";

        criteriaQuery.select(root)      // SELECT * FROM Student11
                .where(criteriaBuilder.equal(root.get("name"), "Student 5"));       // WHERE Student11.name = "Student 5"

        Query<Student11> query3 = session.createQuery(criteriaQuery);
        List<Student11> resultList2 = query3.getResultList();
        for (Student11 stu : resultList2){
            System.out.println(stu);
        }

        // Get the students whose grade are bigger than 80.
        String sqlQuery4 = "SELECT * FROM t_student11 s WHERE s.grade>80";

        criteriaQuery.select(root)      // SELECT * FROM Student11
                .where(criteriaBuilder.greaterThan(root.get("grade"), 80));     // WHERE s.grade>80

        Query<Student11> query4 = session.createQuery(criteriaQuery);
        List<Student11> resultList3 = query4.getResultList();
        resultList3.forEach(s-> System.out.println(s));

        // Get the students whose grade are less than 90.
        String sqlQuery5 = "SELECT * FROM t_student11 s WHERE s.grade<90";

        criteriaQuery.select(root).where(criteriaBuilder.lessThan(root.get("grade"), 90));
        Query<Student11> query5 = session.createQuery(criteriaQuery);
        List<Student11> resultList4 = query5.getResultList();
        resultList4.forEach(System.out::println);


        // Find the records whose id is equal to 1, or grade is greater than 75
        // Predicate

        Predicate predicateForId = criteriaBuilder.equal(root.get("id"), 1L);               //  Student11.id = 1
        Predicate predicateForGrade = criteriaBuilder.greaterThan(root.get("grade"), 75);   //  Student11.grade > 75
        Predicate predicateForOr = criteriaBuilder.or(predicateForId, predicateForGrade);      //    Student11.id = 1 OR Student11.grade > 75

        criteriaQuery.where(predicateForOr);        // WHERE Student11.id = 1 OR Student11.grade > 75
        Query<Student11> query6 = session.createQuery(criteriaQuery);
        List<Student11> resultList5 = query6.getResultList();
        resultList5.forEach(System.out::println);



        tx.commit();
        session.close();
        sessionFactory.close();

    }
}