package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.transaction.internal.TransactionImpl;

public class RunnerSave01 {
    public static void main(String[] args) {
        Student01 student01 = new Student01();
        student01.setId(1001);
        student01.setName("Yusuf Coban");
        student01.setGrade(95);
        Student01 student02 = new Student01();
        student02.setId(1003);
        student02.setName("FGazil Kaya");
        student02.setGrade(25);

        Student01 std3=new Student01();
        std3.setId(1004);
        std3.setGrade(85);
        std3.setName("Ayse Yilmaz");

        // configure metoduna parametre
        Configuration config=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

        SessionFactory sessionFactory= config.buildSessionFactory();//session baslatilmasini saglar
        Session session=sessionFactory.openSession();
        // DB ile iletisime gecip azi islemler yapmamizi saglayan methodlara sahip oldugu icin session olusturmaya

        Transaction tx=session.beginTransaction();

//        session.save(student01);
       session.save(student02);
        session.save(std3);

        tx.commit();
        session.close();
        sessionFactory.close();


    }
}
