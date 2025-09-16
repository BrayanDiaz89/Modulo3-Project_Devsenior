package com.plataforma.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;

import com.plataforma.dto.CourseDTO;
import com.plataforma.exception.CourseNotFoundException;
import com.plataforma.model.Course;

public class CourseService {
    
    private static final Logger log = LogManager.getLogger(CourseService.class);

    private static List<Course> courses;

    public CourseService(){
        courses = new ArrayList<>();
    }

    //Agregar un curso
    public void addCourse(Course course){
        courses.add(course);
        log.info(String.format("Se añadió el curso: %s", course.getNameCourse()));
    }
    //Listar cursos método
    public List<Course> getAllCourses(){
        return courses;
    }

    //Buscar curso por código retornar el curso
    public CourseDTO getCourseById(String idCourse) throws CourseNotFoundException{
        for(Course course : courses){
            if(course.getIdCourse().equals(idCourse)){
                return new CourseDTO(course);
            }
        }
        log.warn(String.format("Curso no encontrado con código: ", idCourse));
        throw new CourseNotFoundException("No se encontró el curso buscado.");
    } 

}
