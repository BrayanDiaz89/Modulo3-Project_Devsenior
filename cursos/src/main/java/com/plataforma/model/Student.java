package com.plataforma.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    
    private String idStudent;
    private String nameStudent;
    private String document;
    private String email;
    private List<Course> courses = new ArrayList<>();

    public Student(String idStudent, String nameStudent, String document, String email) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.document = document;
        this.email = email;
    }

    public Student(){}

    public String getIdStudent() {
        return idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s", nameStudent);
    }

}
