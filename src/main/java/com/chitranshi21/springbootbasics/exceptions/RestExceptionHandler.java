package com.chitranshi21.springbootbasics.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.annotation.Annotation;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        Annotation[] annotations = ex.getClass().getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Annotation) {
                httpStatus = ((ResponseStatus) annotation).value();
            }
        }
        return buildResponseEntity(ex, httpStatus);
    }

    private ResponseEntity<Object> buildResponseEntity(Exception e, HttpStatus httpStatus) {
        log.error("Exception handled:", e);
        return ResponseEntity
                .status(httpStatus)
                .body(ErrorResponse.builder()
                        .timestamp(System.currentTimeMillis())
                        .message(e.getMessage())
                        .build()
                );
    }

}
