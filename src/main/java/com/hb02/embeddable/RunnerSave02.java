package com.hb02.embeddable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {

        Student02 std1=new Student02();
        std1.setName("Ali Hakki");
        std1.setId(25);
        std1.setGrade(99);

        Address adres1= new Address();
        adres1.setStreet("Apple st.");
        adres1.setCity("New York");
        adres1.setCountry("United State");
        adres1.setZipCode("65123");
        std1.setAddress(adres1);

        Student02 std2=new Student02();
        std2.setGrade(85);
        std2.setName("Hakki Yilmaz");

        std2.setId(36);
        Address adres2= new Address();
        adres2.setStreet("Karsiyaka st.");
        adres2.setCity("Van");
        adres2.setCountry("Turkiye");
        adres2.setZipCode("65100");
        std2.setAddress(adres2);

        Configuration con=new Configuration().configure().addAnnotatedClass(Student02.class);
        SessionFactory sf1=con.buildSessionFactory();
        Session session=sf1.openSession();
        Transaction tx=session.beginTransaction();


        session.save(std1);
        session.save(std2);

        tx.commit();
        session.close();
        sf1.close();

    }

}
