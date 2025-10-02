package com.plataforma.cursos;

import com.plataforma.dto.CourseDTO;
import com.plataforma.exception.CourseNotFoundException;
import com.plataforma.model.Course;
import com.plataforma.service.CourseService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseServiceTest {

    @Test
    void testAddCourse() {
        Course course = new Course("ja1", "java principiantes", "desc", 2);
        CourseService service = new CourseService();
        service.addCourse(course);

        assertTrue(service.getAllCourses().contains(course));
    }

    @Test
    void testGetCourseById() throws Exception{
        Course course = new Course("ja1", "java principiantes", "desc", 2);
        CourseDTO courseDTO = new CourseDTO(course);
        CourseService service = new CourseService();
        service.addCourse(course);

        assertEquals(courseDTO, service.getCourseById("ja1"));
    }

    @Test
    void testGetCourseByIdNotFound() throws Exception{
        Course course = new Course("ja1", "java principiantes", "desc", 2);
        CourseDTO courseDTO = new CourseDTO(course);
        CourseService service = new CourseService();
        service.addCourse(course);

        Exception exception = assertThrows(CourseNotFoundException.class, () -> {
           service.getCourseById("ja2");
        });
    }
}
