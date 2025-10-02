package com.plataforma.cursos;

import com.plataforma.dto.StudentListDTO;
import com.plataforma.exception.CourseAndStudentNotRegistration;
import com.plataforma.exception.CourseFullException;
import com.plataforma.exception.StudentAlreadyRegistered;
import com.plataforma.model.Course;
import com.plataforma.model.Student;
import com.plataforma.service.RegistrationService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationServiceTest {


    @Test
    void testRegistrationCourseSuccess() throws Exception {
        Student student = new Student("123", "Brayan", "123", "bryan@gmail.com");
        Course course = new Course("ja1", "java principiantes", "desc", 2);
        RegistrationService service = new RegistrationService();

        service.registrationCourse(course, student);

        assertTrue(course.getStudents().contains(student));
        assertTrue(student.getCourses().contains(course));
    }

    @Test
    void testRegistrationStudentAlreadyRegistered() throws Exception {
        Student student = new Student("123", "Brayan", "123", "bryan@gmail.com");
        Course course = new Course("ja1", "java principiantes", "desc", 2);
        RegistrationService service = new RegistrationService();

        service.registrationCourse(course, student);

        Exception exception = assertThrows(StudentAlreadyRegistered.class, () -> {
            service.registrationCourse(course, student);
        });

        assertTrue(exception.getMessage().contains(String.format("El estudiante con id: %s, ya está registrado en el curso: ", student.getIdStudent())));
    }

    @Test
    void testRegistrationCourseFull() throws Exception {
        Student student = new Student("123", "Brayan", "123", "bryan@gmail.com");
        Student student2 = new Student("124", "Arturo", "9654", "arturo@gmail.com");
        Course course = new Course("ja1", "java principiantes", "desc", 1);
        RegistrationService service = new RegistrationService();

        service.registrationCourse(course, student);

        Exception exception = assertThrows(CourseFullException.class, () -> {
           service.registrationCourse(course, student2);
        });
    }

    @Test
    void testGetAllStudentsWithCoursesRegistration() throws Exception {
        Student student = new Student("123", "Brayan", "123", "bryan@gmail.com");
        Course course = new Course("ja1", "java principiantes", "desc", 2);
        RegistrationService service = new RegistrationService();

        service.registrationCourse(course, student);

        List<StudentListDTO> students = service.getAllStudentsWithCoursesRegistration();

        assertFalse(students.isEmpty());
    }

    @Test
    void testGetAllStudentsWithCoursesRegistrationEmpty() throws Exception {
        RegistrationService service = new RegistrationService();

        Exception exception = assertThrows(CourseAndStudentNotRegistration.class,
                service::getAllStudentsWithCoursesRegistration);
    }
}
