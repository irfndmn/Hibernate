package com.hb10.idgeneration;

import com.hb09.fetchtypes.Book09;
import com.hb09.fetchtypes.Student09;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;

@Entity
@Table(name = "t_student10")
public class Student10 {

    /*
    DBMS defaulttaki otomatik artirma ozelligini kullanarak id i geeretae eder

     */

    @GeneratedValue(generator = "sequencegen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequencegen",  // generated value anotationda kullaniriz bu yuzden bir isim veririz
                        sequenceName = "stud_seq",
                           initialValue = 1000,
                             allocationSize = 5)
    @Id
    private int id;

    private String name;

    private int grade;

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
