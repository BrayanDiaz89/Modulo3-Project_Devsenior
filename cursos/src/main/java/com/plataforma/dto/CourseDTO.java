package com.plataforma.dto;

import java.util.List;

import com.plataforma.model.Course;
import com.plataforma.model.Student;

public record CourseDTO(
    String idCourse,
    String nameCourse,
    List<Student> students
) {
    public CourseDTO(Course course){
        this(course.getIdCourse(), course.getNameCourse(), course.getStudents());
    }
    
}
