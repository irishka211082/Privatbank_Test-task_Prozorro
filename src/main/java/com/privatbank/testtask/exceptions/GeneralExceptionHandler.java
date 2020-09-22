package com.privatbank.testtask.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoChildrenException.class)
    protected ResponseEntity<GeneralException> handleNoItemChildrenException() {
        return new ResponseEntity<>(
                new GeneralException(("There are no children for this item!")),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(NoItemException.class)
    protected ResponseEntity<GeneralException> handleNoItemException() {
        return new ResponseEntity<>(
                new GeneralException(("There is no item with a such id!")),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(NoItemsException.class)
    protected ResponseEntity<GeneralException> handleNoItemsException() {
        return new ResponseEntity<>(
                new GeneralException(("Database is empty!")),
                HttpStatus.NOT_FOUND
        );
    }

    @Data
    @AllArgsConstructor
    private static class GeneralException {
        private String message;
    }
}

