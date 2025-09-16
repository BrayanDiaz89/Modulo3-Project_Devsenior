package com.plataforma.exception;

public class StudentAlreadyRegistered extends Exception {
    public StudentAlreadyRegistered(String message){
        super(message);
    }
}
