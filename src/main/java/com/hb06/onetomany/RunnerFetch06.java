package com.hb06.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch06 {
    public static void main(String[] args) {

        Configuration con=new Configuration().configure().addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);
        SessionFactory sf=con.buildSessionFactory();
        Session ses=sf.openSession();
        Transaction tx= ses.beginTransaction();

        Student06 std=ses.get(Student06.class,1001);

       // System.out.println(std);


        System.out.println(std.getBookList());


        tx.commit();
        ses.close();
        sf.close();
    }
}
