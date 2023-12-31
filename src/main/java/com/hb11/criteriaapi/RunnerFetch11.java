package com.hb11.criteriaapi;

import jdk.jshell.spi.ExecutionControl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.Random;

public class RunnerFetch11 {
    public static void main(String[] args) {



        Configuration con=new Configuration().configure().addAnnotatedClass(Student11.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();

       Student11 std= session.get(Student11.class,1L);
       std.setMathGrade(40);
       session.update(std);

        //TASK: MathGrade puani 30 dan kucuk olan ogrencilerin puanlarini 80 yapalim
        int deafultgrade=30;
        int updatedgrade=80;
        //String hqlQuery="UPDATE Student11 SET mathGrade=80 WHERE mathGrade<30";
        String hqlQuery="UPDATE Student11 SET mathGrade=:sMath WHERE mathGrade<:lMath";
        Query query =session.createQuery(hqlQuery);
        query.setParameter("sMath",updatedgrade);
        query.setParameter("lMath",deafultgrade);

        int updatedrecord=query.executeUpdate();
        System.out.println("Güncellenen kayıt sayısı"+updatedrecord);


        tx.commit();
        session.close();
        sf.close();



    }
}
