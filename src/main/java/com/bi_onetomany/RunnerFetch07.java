package com.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure().addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
       Transaction tx= session.beginTransaction();

       Student07 std=session.get(Student07.class,1001);
        System.out.println(std.getBookList());


        Book07 book=session.get(Book07.class,101);
        System.out.println(book.getStudent());


        tx.commit();
       session.close();
       sf.close();

    }

}
