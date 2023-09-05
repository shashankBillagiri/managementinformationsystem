package com.springpractise.managementinformationsystem.controller;

import com.springpractise.managementinformationsystem.model.NewStudentRequest;
import com.springpractise.managementinformationsystem.model.StudentDetailsResponse;
import com.springpractise.managementinformationsystem.entity.StudentDetails;
import com.springpractise.managementinformationsystem.exception.BadRequestException;
import com.springpractise.managementinformationsystem.exception.StudentsNotFoundException;
import com.springpractise.managementinformationsystem.service.GetStudentDetailsService;
import com.springpractise.managementinformationsystem.service.StudentDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.springpractise.managementinformationsystem.util.MISConstants.*;

@Validated
@RestController
@RequestMapping(REQUEST_MAPPING)
public class StudentController {

    @Autowired
    private  StudentDetailsService studentDetailsService;

    @Autowired
    private   GetStudentDetailsService getStudentDetailsService;

    // Get All  studentdetails
    @GetMapping(value = "/getallstudentdetails")
    public ResponseEntity<StudentDetailsResponse> getStudentDetails(@RequestParam @NotNull(message = "Enter a Valid pageNumber number") @Min(0) int pageNumber,
                                                                    @RequestParam(defaultValue = "3") int pageSize, HttpServletRequest request) {

        StudentDetailsResponse studentDetailsResponse = getStudentDetailsService.getStudentDetails(pageNumber, pageSize, request);


        return ResponseEntity.ok(studentDetailsResponse);
    }

    // Get studentdetails by studentID
    @GetMapping(value = "/getstudentdetailsbystudentid", produces = "application/json")
    public ResponseEntity<StudentDetails> getStudentDetailsByStudID(@RequestParam(required = false) Long studentId) throws StudentsNotFoundException {
        StudentDetails studentsByStudentID = studentDetailsService.getStudentByStudentID(studentId);
        if (studentsByStudentID != null) {
            return ResponseEntity.ok(studentsByStudentID);
        }
        throw new StudentsNotFoundException(String.format(STUDENTS_DO_NOT_EXIST, studentId));

    }

    // Implementing the same as above using pathvariable.
    @GetMapping(value = "/getstudentdetailsbystudentid/{studentID}")
    public ResponseEntity<StudentDetails> getStudentDetailsBySId(@PathVariable Long studentID) throws StudentsNotFoundException {
        StudentDetails studentsByStudentID = studentDetailsService.getStudentByStudentID(studentID);
        if (studentsByStudentID != null) {
            return ResponseEntity.ok(studentsByStudentID);
        }
        throw new StudentsNotFoundException(String.format(STUDENTS_DO_NOT_EXIST, studentID));
    }

    //Get studentdetails by First name
    @GetMapping(value = "/getstudentdetailsbyfirstname", produces = "application/json")
    public ResponseEntity<List<StudentDetails>> getStudentDetailsByFirstName(@RequestParam(required = false) String firstName) throws StudentsNotFoundException {
        List<StudentDetails> studentsByFirstName = studentDetailsService.getStudentByFirstName(firstName);

        if (studentsByFirstName.size() > 0) {
            return ResponseEntity.ok(studentsByFirstName);
        }

        throw new StudentsNotFoundException(String.format(STUDENTS_DO_NOT_EXIST, firstName));
    }

    // to create Multiple or single Records in a single Request.
    @PostMapping(value = "/newstudents")
    public ResponseEntity<List<StudentDetails>> createNewStudents(@RequestBody List<NewStudentRequest> newStudents) throws BadRequestException {

        for (NewStudentRequest newStudent : newStudents) {

            if (studentDetailsService.getStudentById(newStudent.getId()) > 0) {

                throw new BadRequestException(String.format(DUPLICATE_ID, newStudent.getId()));
            }

            if (!VALID_COURSES.contains(newStudent.getCourse().toUpperCase())) {

                throw new BadRequestException(INVALID_COURSE);
            }

        }
        return new ResponseEntity<>(studentDetailsService.createNewStudents(newStudents), HttpStatus.CREATED);

    }


    @DeleteMapping("/deletedtudentsbystudentids/{studentIds}")
    public void  deleteStudent(@PathVariable  List<Long> studentIds) {
        studentDetailsService.deleteStudentByStudentID(studentIds);
    }
}
