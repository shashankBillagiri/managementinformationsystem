package com.springpractise.managementinformationsystem.controller;

import com.springpractise.managementinformationsystem.entity.StudentDetails;
import com.springpractise.managementinformationsystem.service.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/studentdatabasemanagement")
public class StudentController {

    @Autowired
    private StudentDetailsService studentDetailsService;

    @GetMapping(value = "/studentdetails")
    List<StudentDetails> retrieveStudentDetails() {
        return  studentDetailsService.getStudentDetails();
    }
}
