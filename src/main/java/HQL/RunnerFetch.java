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
        for(Student01 student: studentList){
            System.out.println(student);
        }

        //studentList.forEach(student-> System.out.println(Arrays.toString(student)));






        tx.commit();
        session.close();
        sf.close();
    }
}
