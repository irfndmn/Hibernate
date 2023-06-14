package com.hb02.embeddable;

import com.hb05.ManyToOne.Student05;
import com.hb05.ManyToOne.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch05 {
    public static void main(String[] args) {


        Configuration config = new Configuration().configure().
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sessionFactory = config.buildSessionFactory();//session başlatılmasını sağlar
        Session session = sessionFactory.openSession();
        //sesssion DB ile iletişime geçip bazı işlemler yapmamızı sağlayan metodlara sahip
        Transaction tx = session.beginTransaction();


        Student05 std = session.get(Student05.class, 1001);
        System.out.println(std);
        University unv = session.get(University.class, 1);
        System.out.println(unv);


        tx.commit();
        session.close();
        sessionFactory.close();


    }
}
