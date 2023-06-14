package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {
        // configure metoduna parametre
        Configuration config=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

        SessionFactory sessionFactory= config.buildSessionFactory();//session baslatilmasini saglar
        Session session=sessionFactory.openSession();
        // DB ile iletisime gecip azi islemler yapmamizi saglayan methodlara sahip oldugu icin session olusturmaya

        Transaction tx=session.beginTransaction();



        // 1 YOL: sessionun methodunu kullanma



//        Student01 std= session.get(Student01.class,1001);
//        Student01 std1= session.get(Student01.class,1003);
//        Student01 std2= session.get(Student01.class,1004);
//        System.out.println(std);
//        System.out.println(std1);
//        System.out.println(std2);




        // 2. yol   SQL kullanma



//        String query="SELECT * FROM t_student01";
//        List<Object[]> resultList =session.createSQLQuery(query).getResultList();
//        for(Object [] a:resultList){
//            System.out.println(Arrays.toString(a));
//        }



        // 3 YOL HQL Kullanma
//        String hqlQuery="FROM Student01";
//        List<Student01> resultList2= session.createQuery(hqlQuery,Student01.class).getResultList();
//        for(Student01 std:resultList2){
//            System.out.println(std);
//        }


//
//        String sqlQuery2 = "SELECT * FROM t_student01 WHERE std_name='Yusuf Coban'";
//        Object[] std= (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
//
//        System.out.println(Arrays.toString(std));

//        String hqlQuery2 = " FROM Student01 WHERE name='Yusuf Coban'";
//        Student01 std2=session.createQuery(hqlQuery2,Student01.class).uniqueResult();
//        System.out.println(std2);



        String hqlQuery3 = " SELECT std.id, std.name FROM Student01 std WHERE std.grade=95";

       Object[] result= (Object[]) session.createQuery(hqlQuery3).uniqueResult();
//        System.out.println(Arrays.toString(result));
//        Object[] st= (Object[]) session.createQuery(hqlQuery3).uniqueResult();
//        System.out.println(Arrays.toString(st));



        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
