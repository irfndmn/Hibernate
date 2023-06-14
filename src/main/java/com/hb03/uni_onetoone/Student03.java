package com.hb03.uni_onetoone;

import javax.persistence.Column;
import javax.persistence.Id;

public class Student03 {

    @Id//primary key oluşmasını sağlıyoruz
    private int id;

    @Column(name="std_name",length = 100,nullable = false,unique = false)//opsiyonel
    private String name;

    private int grade;



        //GETTER-SETTER


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    //toString
    @Override
    public String toString() {
        return "Student03{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
