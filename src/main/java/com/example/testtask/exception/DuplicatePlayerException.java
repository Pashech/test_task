package com.example.testtask.exception;

public class DuplicatePlayerException extends RuntimeException{

    public DuplicatePlayerException(String message) {
        super(message);
    }
}
