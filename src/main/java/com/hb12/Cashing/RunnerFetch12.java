package com.hb12.Cashing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {
    public static void main(String[] args) {
        Configuration con=new Configuration().configure().addAnnotatedClass(Student12.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();


        System.out.println("Ilk sorgu");
        Student12 std=session.get(Student12.class,1L);
        System.out.println(std);

        //session.clear();// Bu sessiondaeki cash e alinan datalari temizler


//        System.out.println("Ikinci sorgu");
//        Student12 std1=session.get(Student12.class,1L);
//        System.out.println(std1);



        tx.commit();
        session.close();

        Session session1= sf.openSession();

        Transaction tx1= session1.beginTransaction();





       tx1.commit();
       session1.close();
        sf.close();
    }
}
