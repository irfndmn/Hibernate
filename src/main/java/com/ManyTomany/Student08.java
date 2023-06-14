package com.ManyTomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_student08")
public class Student08 {

    @Id
    private int id;
    private String name;

    private int grade;

    @ManyToMany
    @JoinTable(name="student08_course08",
               joinColumns = {@JoinColumn(name="std_id")},
               inverseJoinColumns = {@JoinColumn(name="course_id")})  // Opsiyonel
    private List<Course08> courseList=new ArrayList<>();

    public Student08() {
    }

    public Student08(int id, String name, int grade, List<Course08> courseList) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.courseList = courseList;
    }


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

    public List<Course08> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course08> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", courseList=" + courseList +
                '}';
    }
}
