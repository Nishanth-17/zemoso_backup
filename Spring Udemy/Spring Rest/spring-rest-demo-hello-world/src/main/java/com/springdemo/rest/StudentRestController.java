package com.springdemo.rest;

import com.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentRestController {
    private List<Student> theStudents;
    @PostConstruct //This annotation is used to perform any initializations
    public void loadData(){
        theStudents=new ArrayList<>();
        theStudents.add(new Student("Nishanth","Badim"));
        theStudents.add(new Student("Naren","Raju"));
        theStudents.add(new Student("Disco","Raja"));
    }
    @GetMapping("/get")
    public List<Student> getStudents(){
        return theStudents;
    }
    @GetMapping("/get/{studentId}")
    public Student getStudentbyId(@PathVariable int studentId){
        if(studentId>theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student ID not found - " + studentId);
        }
        return theStudents.get(studentId);
    }
      /*  //Add Exception Handler
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
    //Exception Handler for all types of errors
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
    */
}
