package com.plataforma.dto;

import java.util.List;

import com.plataforma.model.Course;
import com.plataforma.model.Student;

public record StudentListDTO(
    String name,
    List<Course> courses
) {
    public StudentListDTO(Student student){
        this(student.getNameStudent(), student.getCourses());
    }
}
