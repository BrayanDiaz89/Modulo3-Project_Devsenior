package com.plataforma.exception;

public class CourseFullException extends Exception {
    
    public CourseFullException(String message){
        super(message);
    }

    public CourseFullException(String message, Throwable cause){
        super(message, cause);
    }

}
