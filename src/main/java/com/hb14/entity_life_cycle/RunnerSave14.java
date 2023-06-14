package com.hb14.entity_life_cycle;

import com.hb13.getveload.Student13;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {
    public static void main(String[] args) {
        Student14 student1 = new Student14();
        student1.setName("Ali Can");
        student1.setGrade(100);

        Student14 student2 = new Student14();
        student2.setName("Veli Han");
        student2.setGrade(100);

        Student14 student3 = new Student14();
        student3.setName("Ayse Tan");
        student3.setGrade(100);
        Configuration con=new Configuration().configure().addAnnotatedClass(Student14.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();



        tx.commit();

        session.close();
        sf.close();
    }
}
