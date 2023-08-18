package com.springpractise.managementinformationsystem.controller;

import com.springpractise.managementinformationsystem.entity.StudentDetails;
import com.springpractise.managementinformationsystem.exception.CommonExceptionHandler;
import com.springpractise.managementinformationsystem.service.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/v1/mis")
public class StudentController {

    @Autowired
    private StudentDetailsService studentDetailsService;

    @GetMapping(value = "/studentdetails")
    public List<StudentDetails> getStudentDetails() {
        return studentDetailsService.getStudentDetails();
    }

    @GetMapping(value = "/getstudentdetailsByStudentID")
    public StudentDetails getStudentDetails(@RequestParam(required = false) Long StudentId) {
        return studentDetailsService.getStudentByID(StudentId);
    }

    // Implementing the same as above using pathvariable
    @GetMapping(value = "/getstudentdetailsByStudentID/{StudentId}")
    public StudentDetails getStudentDetailss(@PathVariable Long StudentId) {
        return studentDetailsService.getStudentByID(StudentId);
    }

    @PostMapping(value = "/newstudent")
    public List<StudentDetails> createNewStudents(@RequestBody List<StudentDetails> newStudents) {
        return studentDetailsService.createNewStudent(newStudents);

    }
}
