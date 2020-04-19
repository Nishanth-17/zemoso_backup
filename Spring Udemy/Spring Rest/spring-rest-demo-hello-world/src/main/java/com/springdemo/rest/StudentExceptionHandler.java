package com.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {

    //Add exception handling code
     //Add Exception Handler
        @ExceptionHandler
        public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
            // Create a StudentErrorResponse
            StudentErrorResponse err=new StudentErrorResponse();
            err.setStatus(HttpStatus.NOT_FOUND.value());
            err.setMessage(exc.getMessage());
            err.setTimeStamp((int) System.currentTimeMillis());
            //return response Entity
            return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }
    //Exception Handler for all types of errors---catch all
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        // Create a StudentErrorResponse
        StudentErrorResponse err=new StudentErrorResponse();
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(exc.getMessage());
        err.setTimeStamp((int) System.currentTimeMillis());
        //return response Entity
        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }

}
