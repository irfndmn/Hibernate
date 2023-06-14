package com.hb09.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure()
                .addAnnotatedClass(Student09.class)
                .addAnnotatedClass(Book09.class)
                .buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        Student09 std = session.get(Student09.class, 1001);
        //System.out.println(std);

        //System.out.println(std.getBookList());
//        for(Book09 book:std.getBookList()){
//            System.out.println(book);
//        }


        tx.commit();
        session.close();

        System.out.println(std.getBookList());

        sf.close();
    }
}

