package com.ManyTomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure()
                .addAnnotatedClass(Course08.class)
                .addAnnotatedClass(Student08.class)
                .buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        Student08 std=session.get(Student08.class,1001);
        System.out.println(std);
       // System.out.println(std.getCourseList());









        tx.commit();
        session.close();
        sf.close();

    }
}
