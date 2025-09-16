package com.plataforma.model;

import java.time.LocalDateTime;

public class Registration {

    private Course course;
    private Student student;
    private LocalDateTime dateInscription;

    public Registration(Course course, Student student) {
        this.course = course;
        this.student = student;
        this.dateInscription = LocalDateTime.now();
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDateTime getDateInscription() {
        return dateInscription;
    }

     @Override
     public String toString() {
         // TODO Auto-generated method stub
         return super.toString();
     }

}
