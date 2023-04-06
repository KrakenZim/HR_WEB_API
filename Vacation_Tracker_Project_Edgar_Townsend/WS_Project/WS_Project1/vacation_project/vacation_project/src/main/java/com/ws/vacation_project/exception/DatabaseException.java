package com.ws.vacation_project.exception;

public class DatabaseException extends RuntimeException{
    private String message;

    public DatabaseException(String message){
        super(message);
    }

}
