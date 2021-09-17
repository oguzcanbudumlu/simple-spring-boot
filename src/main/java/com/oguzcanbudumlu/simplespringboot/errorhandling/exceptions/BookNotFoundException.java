package com.oguzcanbudumlu.simplespringboot.errorhandling.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
