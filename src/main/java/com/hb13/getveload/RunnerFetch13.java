package com.hb13.getveload;

import com.hb11.criteriaapi.Student11;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
   get() ---> gerçek nesneyi döndürür ,
   			  nesne yoksa null döner
   			  nesnenin olduğundan emin değilseniz get() kullanın
   			  dönen nesneyi hemen kullanacaksam get() kullanılmalı
   load() --> proxy nesne döndürür, gerçek nesnenin gölgesi ,
   			  nesne yoksa exception fırlatır
   			  dönen nesne üzerinde delete yapılacaksa kullanılabilir
 */




public class RunnerFetch13 {
    public static void main(String[] args) {

        Configuration con=new Configuration().configure().addAnnotatedClass(Student13.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();

        //get

        System.out.println("Get Methodu Cagriliyor...");
        Student13 std=session.get(Student13.class,1L);
        System.out.println("Student id : "+std.getId());
        System.out.println("Student name : "+std.getName());


        //load
        System.out.println("Load Methodu Cagriliyor");
        session.load(Student13.class,1L);




        tx.commit();

        session.close();
        sf.close();
    }
}
