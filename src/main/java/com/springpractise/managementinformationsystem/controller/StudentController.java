package com.springpractise.managementinformationsystem.controller;

import com.springpractise.managementinformationsystem.dto.NewStudent;
import com.springpractise.managementinformationsystem.entity.StudentDetails;
import com.springpractise.managementinformationsystem.exception.BadRequestException;
import com.springpractise.managementinformationsystem.exception.StudentsNotFoundException;
import com.springpractise.managementinformationsystem.service.StudentDetailsService;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.springpractise.managementinformationsystem.util.MISConstants.DUPLICATE_ID;
import static com.springpractise.managementinformationsystem.util.MISConstants.STUDENTS_DO_NOT_EXIST;

@RestController
@RequestMapping("/v1/mis")
public class StudentController {

    @Autowired
    private StudentDetailsService studentDetailsService;

    // Get All  studentdetails
    @GetMapping(value = "/getAllstudentdetails")
    public ResponseEntity<List<StudentDetails>> getStudentDetails() {
        return ResponseEntity.ok(studentDetailsService.getStudentDetails());
    }

    // Get studentdetails by studentID
    @GetMapping(value = "/getstudentdetailsByStudentID",produces = "application/json")
    public ResponseEntity<StudentDetails> getStudentDetails(@RequestParam(required = false) Long StudentId) {
        return ResponseEntity.ok(studentDetailsService.getStudentByStudentID(StudentId));
    }

    // Implementing the same as above using pathvariable.
    @GetMapping(value = "/getstudentdetailsByStudentID/{StudentId}")
    public ResponseEntity<StudentDetails> getStudentDetailss(@PathVariable Long StudentId) {
        return ResponseEntity.ok(studentDetailsService.getStudentByStudentID(StudentId));
    }

    //Get studentdetails by First name
    @GetMapping(value = "/getstudentdetailsByFirstName",produces = "application/json")
    public ResponseEntity<List<StudentDetails>> getStudentDetailsByFirstName(@RequestParam(required = false) String firstName) throws StudentsNotFoundException {
        List<StudentDetails> studentsByFirstName = studentDetailsService.getStudentByFirstName(firstName);

        if (studentsByFirstName.size() > 0){
            return  ResponseEntity.ok(studentsByFirstName);
        }

       throw new StudentsNotFoundException(STUDENTS_DO_NOT_EXIST +firstName);
    }

    // to create Multiple or single Records in a single Request.
    @PostMapping(value = "/newstudents")
    public ResponseEntity<List<StudentDetails>> createNewStudents(  @RequestBody List<StudentDetails> newStudents) throws BadRequestException {

        for (StudentDetails  newStudent:newStudents) {
            if (studentDetailsService.getStudentById(newStudent.getId())>0){

                throw new BadRequestException(DUPLICATE_ID + newStudent.getId());
            }

        }
        return new ResponseEntity<>(studentDetailsService.createNewStudents(newStudents), HttpStatus.CREATED);

    }


 /*  Using @Sneaky throws inplace  of using Throws in Method Signature,
    Using dto Request Object inplace of directly using Entity*/
    @SneakyThrows
    @PostMapping("/newstudent")
    public ResponseEntity<StudentDetails> createNewStudent( @Valid  @RequestBody NewStudent newStudent) {
        if (studentDetailsService.getStudentById(newStudent.getId())>0){
                throw new BadRequestException(DUPLICATE_ID + newStudent.getId());
        }

        return new ResponseEntity<>(studentDetailsService.createNewStudent(newStudent), HttpStatus.CREATED);

    }
}
