package com.plataforma;

import com.plataforma.dto.StudentListDTO;
import com.plataforma.exception.CourseAndStudentNotRegistration;
import com.plataforma.exception.CourseFullException;
import com.plataforma.exception.CourseNotFoundException;
import com.plataforma.exception.StudentAlreadyRegistered;
import com.plataforma.model.Course;
import com.plataforma.model.Student;
import com.plataforma.service.CourseService;
import com.plataforma.service.RegistrationService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        try {
            List<StudentListDTO> students;
            CourseService serviceCourse = new CourseService(); 
            RegistrationService registrationService = new RegistrationService();
            
            Course java1 = new Course("ja1", "java principiantes", "desc", 2); 
            Course java2 = new Course("ja2", "java interm", "desc", 1); 
            
            Student student1 = new Student("123", "Brayan", "123", "bryan@gmail.com");
            Student student2 = new Student("524", "oconer", "852", "oconer@gmail.com");
            Student student3 = new Student("635", "prime", "951", "prime@gmail.com");

            serviceCourse.addCourse(java1);
            serviceCourse.addCourse(java2);
            registrationService.registrationCourse(java1, student1);
            registrationService.registrationCourse(java1, student2);
            registrationService.registrationCourse(java2, student3);

            var course = serviceCourse.getCourseById("ja2");
            System.out.println(course);

            students = registrationService.getAllStudentsWithCoursesRegistration();
            students.forEach(System.out::println);

        } catch (CourseNotFoundException e) {
            System.out.println("Error curso no encontrado");
        } catch (StudentAlreadyRegistered e){
            System.out.println("Error, estudiante ya registrado");
        } catch (CourseFullException e){
            System.out.println("Error. Curso lleno");
        } catch (CourseAndStudentNotRegistration e){
            System.out.println("No hay estudiantes, ni cursos aun registrados");
        }

    }
}