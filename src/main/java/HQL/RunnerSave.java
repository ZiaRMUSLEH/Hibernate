package HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
    public static void main (String[] args) {

        Student01 student1 = new Student01(1001L,"Jace",90);
        Student01 student2 = new Student01(1002L,"John",90);
        Student01 student3 = new Student01(1003L,"Mark",90);
        Student01 student4 = new Student01(1004L,"Tom",90);
        Student01 student5 = new Student01(1005L,"Jerry",90);


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();



        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(student5);



        tx.commit();
        session.close();
        sf.close();


    }
}
