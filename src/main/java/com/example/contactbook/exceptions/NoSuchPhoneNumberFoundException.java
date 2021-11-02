package com.example.contactbook.exceptions;

public class NoSuchPhoneNumberFoundException extends RuntimeException{

    public NoSuchPhoneNumberFoundException(String message) {
        super(message);
    }
}
