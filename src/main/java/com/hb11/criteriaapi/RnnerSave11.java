package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RnnerSave11 {

        public static void main(String[] args) {
            Configuration con=new Configuration().configure().addAnnotatedClass(Student11.class);

            SessionFactory sf= con.buildSessionFactory();
            Session session=sf.openSession();
            Transaction tx= session.beginTransaction();


            Random random=new Random();
            for(int i=1;i<=20;i++){
                Student11 std=new Student11();
                std.setName("Student "+ i);
                std.setMathGrade(random.nextInt(101));
                session.save(std);
            }


            tx.commit();
            session.close();
            sf.close();
        }
    }

