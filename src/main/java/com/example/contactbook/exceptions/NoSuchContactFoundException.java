package com.example.contactbook.exceptions;

public class NoSuchContactFoundException extends RuntimeException{

    public NoSuchContactFoundException(String message) {
        super(message);
    }
}

