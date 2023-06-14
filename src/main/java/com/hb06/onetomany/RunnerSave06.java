package com.hb06.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave06 {
    public static void main(String[] args) {


        Student06 std1=new Student06(1001,"Fazil Bey",90);
        Student06 std2=new Student06(1002,"Aynur Hanim",90);
        Student06 std3=new Student06(1003,"Yavuz Bey",90);

        Book06 book1=new Book06(101,"Java Book");
        Book06 book2=new Book06(102,"Math Book");
        Book06 book3=new Book06(103,"Chem Book");

        std1.getBookList().add(book1);
        std1.getBookList().add(book2);


                List<Book06> bookList = new ArrayList<>();
                bookList.add(book3);
                std2.setBookList(bookList);


        Configuration con = new Configuration().configure().addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);
        SessionFactory sf = con.buildSessionFactory();
        Session ses = sf.openSession();
        Transaction tx = ses.beginTransaction();

       ses.save(book1);
       ses.save(book2);
       ses.save(book3);

       ses.save(std1);
       ses.save(std2);
       ses.save(std3);




      tx.commit();
      ses.close();
      sf.close();


    }
}
