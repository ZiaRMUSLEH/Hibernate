package HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch {
    public static void main (String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String hq1 = "FROM Student01";
        List <Student01>  studentList = session.createQuery(hq1).getResultList();
        //studentList.forEach(student-> System.out.println(student));

        String hq2 = "FROM Student01 S";
        List <Student01>  studentList1 = session.createQuery(hq2).getResultList();
        //studentList1.forEach(student-> System.out.println(student));

        String hq3 = "SELECT s.name FROM Student01 s WHERE name = 'Jace'";
        List<Object> resultList1 = session.createQuery(hq3).getResultList();

        resultList1.forEach(t-> System.out.println(t));









        tx.commit();
        session.close();
        sf.close();
    }
}
