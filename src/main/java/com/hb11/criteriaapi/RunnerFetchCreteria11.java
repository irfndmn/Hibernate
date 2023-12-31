package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetchCreteria11 {
    public static void main(String[] args) {



        Configuration con=new Configuration().configure().addAnnotatedClass(Student11.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();


        //---------------------Criteria API---------------------------------
        //SQL-HQL string bazlı, hataya açık
        //Criteria API:Javada metodlar kullanarak sorgulama
        //avantajı:derleme anında hata almamızı sağlar
        //Read:CriteriaQuery
        //Update:CriteriaUpdate
        //Delete:CriteriaDelete

        CriteriaBuilder cb =session.getCriteriaBuilder();//cb objesi ile CriteriaQuery oluşturabiliriz
        // ve cb ın bazı metodlarını sorgularımızda kullanabiliriz.

        CriteriaQuery<Student11> criteriaQuery=cb.createQuery(Student11.class);

        Root<Student11> root=criteriaQuery.from(Student11.class);


        //!!! 1.Örnek: butun Student11 objelerini ekrana basalim:
        criteriaQuery.select(root); //SELECT * FROM Student11

//        List<Student11> resultList=session.createQuery(criteriaQuery).getResultList();
//        resultList.forEach(System.out::println);

        //!!! 2.Örnek , Student ismi "Student 6" olan öğrenci bilgilerini getirelim\
        //SELECT * FROM Student11 WHERE name='Student 6';

//        criteriaQuery.select(root)
//                     .where(cb.equal(root.get("name"),"Student 6"));
//
//        List<Student11> resulList2=session.createQuery(criteriaQuery).getResultList();
//        resulList2.forEach(System.out::println);

        //!!!  3.Örnek, mathGrade değeri 80 den büyük olan öğrenci bilgilerini getirelim.

//        criteriaQuery.select(root).
//                      where(cb.greaterThan(root.get("mathGrade"),80));
//
//        List<Student11> resultList3=session.createQuery(criteriaQuery).getResultList();
//        resultList3.forEach(System.out::println);

        //!!!  4.Örnek, mathGrade değeri 50 den küçük olan öğrenci bilgilerini getirelim.
        criteriaQuery.select(root).
                where(cb.lessThan(root.get("mathGrade"),50));

        List<Student11> resultList4=session.createQuery(criteriaQuery).getResultList();
        resultList4.forEach(System.out::println);

        // !!! 5. örnek : id si 1 veya mathGrade i 90 den büyük olan recordu bulalım


        Predicate pred1=cb.equal(root.get("id"),1);
        Predicate pred2=cb.greaterThan(root.get("mathGrade"),90);
        Predicate predOr=cb.or(pred1,pred2);

        criteriaQuery.select(root).where(predOr);//where predicate ister

        List<Student11> resultList5=session.createQuery(criteriaQuery).getResultList();
        resultList5.forEach(System.out::println);


        Predicate pred3=cb.equal(root.get("id"),1);
        Predicate pred4=cb.greaterThan(root.get("mathGrade"),90);
        Predicate predOrt=cb.or(pred3,pred4);

        criteriaQuery.select(root).where(predOrt);//where predicate ister

        List<Student11> resultList6=session.createQuery(criteriaQuery).getResultList();
        resultList5.forEach(System.out::println);
        tx.commit();
        session.close();
        sf.close();



    }
}
