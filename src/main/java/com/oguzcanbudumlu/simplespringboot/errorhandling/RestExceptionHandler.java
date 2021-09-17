package com.oguzcanbudumlu.simplespringboot.errorhandling;

import com.oguzcanbudumlu.simplespringboot.errorhandling.exceptions.BookIdMismatchException;
import com.oguzcanbudumlu.simplespringboot.errorhandling.exceptions.BookNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ BookNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(
            Exception ex, WebRequest request
    ) {
        return handleExceptionInternal(ex,
                "Book not found",
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                request);
    }


    @ExceptionHandler({BookIdMismatchException.class,
            ConstraintViolationException.class,
            DataIntegrityViolationException.class
    })
    public ResponseEntity<Object> handleBadRequst(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getLocalizedMessage(),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request);
    }

}
