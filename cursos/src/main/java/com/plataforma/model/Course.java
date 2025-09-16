package com.plataforma.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    
    private String idCourse;
    private String nameCourse;
    private String description;
    private Integer capacity;
    private List<Student> students = new ArrayList<>();

    public Course(String idCourse, String nameCourse, String description, Integer capacity) {
        this.idCourse = idCourse;
        this.nameCourse = nameCourse;
        this.description = description;
        this.capacity = capacity;
    }

    public Course() {}

    public String getIdCourse() {
        return idCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    
    @Override
    public String toString() {
        return String.format("Curso: %s", nameCourse);
    } 
 
    
       
}
