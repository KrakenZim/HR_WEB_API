package com.ws.vacation_project.exception;

public class EmployeeNotFoundException extends RuntimeException{
    private String message;

    public EmployeeNotFoundException(String message){
        super(message);
    }
}
