package com.hb06.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Book06 {///Many

    @Id
    private int id;

    private String name;


    public Book06() {
    }

    public Book06(int id, String name) {
        this.id = id;
        this.name = name;
    }


    //getter settr


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

    @Override
    public String toString() {
        return "Book06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
