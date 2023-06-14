package com.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {
        Configuration con=new Configuration().configure().addAnnotatedClass(Student02.class);
        SessionFactory sf1=con.buildSessionFactory();
        Session session=sf1.openSession();
        Transaction tx=session.beginTransaction();

        Student02 st=session.get(Student02.class,25);
        System.out.println(st);

        tx.commit();
        session.close();
        sf1.close();
    }
}
