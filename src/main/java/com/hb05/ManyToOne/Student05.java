package com.hb05.ManyToOne;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_student05")
public class Student05 {

    @Id
    private int id;

    @Column(nullable = false)
    private String name;

    private int grade;

    private LocalDateTime createOn;// obj DB kaydedildiginde set edelim

    @ManyToOne
    @JoinColumn(name = "uni_id")
    private University university;


    @PrePersist// Obje database kaydedilmeden hemen once su methodu cagir
    public void prePersist(){
        this.createOn=LocalDateTime.now();
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

    public LocalDateTime getCreateOn() {
        return createOn;
    }

//    public void setCreateOn(LocalDateTime createOn) {
//        this.createOn = createOn;
//    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", university=" + university +
                '}';
    }
}
