package com.plataforma.service;
import java.util.ArrayList;
import java.util.List;

import com.plataforma.dto.StudentListDTO;
import com.plataforma.exception.CourseAndStudentNotRegistration;
import com.plataforma.exception.CourseFullException;
import com.plataforma.exception.CourseNotFoundException;
import com.plataforma.exception.StudentAlreadyRegistered;
import com.plataforma.model.Course;
import com.plataforma.model.Student;
import org.apache.logging.log4j.*;

public class RegistrationService {

    private List<Course> courseRegistrations = new ArrayList<>();
    private static final Logger log = LogManager.getLogger(RegistrationService.class);

    public void registrationCourse(Course course, Student student) throws StudentAlreadyRegistered, CourseFullException{

        var idStudent = student.getIdStudent();
        if(!courseIsFullCapacity(course)){
            if(!studenExistsInCourse(course.getStudents(), idStudent)){
            course.addStudent(student);
            student.addCourse(course);
            courseRegistrations.add(course);
            } else{
                log.warn(String.format("Se ha intentado registrar al estudiante: %s. ya registrado.", student.getNameStudent()));
                throw new StudentAlreadyRegistered(String.format("El estudiante con id: %s, ya está registrado en el curso: ", idStudent));
            }
        } else {
            throw new CourseFullException(String.format("El curso %s está full, no se admiten mas estudiantes.", course.getNameCourse()));
        }
    }

    public boolean studenExistsInCourse(List<Student> students, String idStudent){
        for(Student student : students){
            if(student.getIdStudent().equals(idStudent)){
                return true;
            }
        }
        return false;
    }

    public boolean courseIsFullCapacity(Course course){
        return course.getCapacity() <= course.getStudents().size();
    }

    public List<StudentListDTO> getAllStudentsWithCoursesRegistration() throws CourseAndStudentNotRegistration{
        List<StudentListDTO> studentsWithCourses = new ArrayList<>();
        for(Course course : courseRegistrations){
            for(Student student : course.getStudents()){
                    var studentNew = new StudentListDTO(student.getNameStudent(), student.getCourses());
                    studentsWithCourses.add(studentNew);
            }
        }
        if(studentsWithCourses.isEmpty()){
            throw new CourseAndStudentNotRegistration("No hay estudiantes, ni cursos.");
        }
        return studentsWithCourses.stream()
                .distinct()
                .toList();
    }
}
