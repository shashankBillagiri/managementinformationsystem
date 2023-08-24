package com.springpractise.managementinformationsystem.controller;

import com.springpractise.managementinformationsystem.entity.StudentDetails;
import com.springpractise.managementinformationsystem.exception.BadRequestException;
import com.springpractise.managementinformationsystem.service.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.springpractise.managementinformationsystem.util.MISConstants.DUPLICATE_ID;

@RestController
@RequestMapping("/v1/mis")
public class StudentController {

    @Autowired
    private StudentDetailsService studentDetailsService;


    @GetMapping(value = "/studentdetails")
    public List<StudentDetails> getStudentDetails() {
        return studentDetailsService.getStudentDetails();
    }

    @GetMapping(value = "/getstudentdetailsByStudentID",produces = "application/json")
    public StudentDetails getStudentDetails(@RequestParam(required = false) Long StudentId) {
        return studentDetailsService.getStudentByStudentID(StudentId);
    }

    // Implementing the same as above using pathvariable.
    @GetMapping(value = "/getstudentdetailsByStudentID/{StudentId}")
    public StudentDetails getStudentDetailss(@PathVariable Long StudentId) {
        return studentDetailsService.getStudentByStudentID(StudentId);
    }


    @GetMapping(value = "/getstudentdetailsByFirstName",produces = "application/json")
    public List<StudentDetails> getStudentDetailsByFirstName(@RequestParam(required = false) String firstName) {
        return studentDetailsService.getStudentByFirstName(firstName);
    }

    // to create Multiple or single Records in a single Request.
    @PostMapping(value = "/newstudents")
    public List<StudentDetails> createNewStudents(@RequestBody List<StudentDetails> newStudents) throws BadRequestException {

        for (StudentDetails  newStudent:newStudents) {
            if (studentDetailsService.getStudentById(newStudent.getId())>0){

                throw new BadRequestException(DUPLICATE_ID);
            }

        }
        return studentDetailsService.createNewStudents(newStudents);

    }

    @PostMapping(value = "/newstudent")
    public StudentDetails createNewStudent(@RequestBody StudentDetails newStudent) {
        if (studentDetailsService.getStudentById(newStudent.getId())>0){
            try {
                throw new BadRequestException(DUPLICATE_ID);
            } catch (BadRequestException e) {
                e.printStackTrace();
            }
        }

        return studentDetailsService.createNewStudent(newStudent);

    }
}
