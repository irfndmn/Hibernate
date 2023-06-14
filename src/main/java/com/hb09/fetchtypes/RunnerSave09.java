package com.hb09.fetchtypes;

import com.ManyTomany.Course08;
import com.ManyTomany.Student08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {
    public static void main(String[] args) {

        Student09 student1 = new Student09(1001, "Ali", 95);
        Student09 student2 = new Student09(1002, "Veli", 98);
        Student09 student3 = new Student09(1003, "Can", 91);

        Book09 book1 = new Book09(101, "A Book", student1);
        Book09 book2 = new Book09(102, "B Book", student1);
        Book09 book3 = new Book09(103, "C Book", student2);
        Book09 book4 = new Book09(104, "D Book", student2);
        Book09 book5 = new Book09(105, "E Book", student3);


        SessionFactory sf = new Configuration().configure()
                .addAnnotatedClass(Student09.class)
                .addAnnotatedClass(Book09.class)
                .buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);


        tx.commit();
        session.close();
        sf.close();
    }
}
