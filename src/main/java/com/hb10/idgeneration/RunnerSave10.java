package com.hb10.idgeneration;

import com.hb09.fetchtypes.Book09;
import com.hb09.fetchtypes.Student09;
import jdk.jshell.spi.ExecutionControl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {
    public static void main(String[] args) {


        Student10 std=new Student10();
        std.setName("Ali");
        std.setGrade(28);
        Student10 std2=new Student10();
        std2.setName("Aliff");
        std2.setGrade(281);



        SessionFactory sf = new Configuration().configure()
                .addAnnotatedClass(Student10.class).buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();


       session.save(std);
        session.save(std2);





        tx.commit();
        session.close();

        sf.close();
    }
}
