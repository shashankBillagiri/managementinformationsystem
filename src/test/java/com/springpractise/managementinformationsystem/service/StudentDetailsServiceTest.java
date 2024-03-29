package com.springpractise.managementinformationsystem.service;

import com.springpractise.managementinformationsystem.entity.StudentDetails;
import com.springpractise.managementinformationsystem.model.NewStudentRequest;
import com.springpractise.managementinformationsystem.repository.StudentDetailsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class StudentDetailsServiceTest {

    AutoCloseable autoCloseable;
    List<StudentDetails> studentDetails = new ArrayList<StudentDetails>();
    @Mock
    private StudentDetailsRepository studentDetailsRepository;
    @Autowired
    private StudentDetailsService studentDetailsService;

    @BeforeEach
    void setUp() {

        autoCloseable = MockitoAnnotations.openMocks(this);

        studentDetailsService = new StudentDetailsService(studentDetailsRepository);

        StudentDetails newStudent = new StudentDetails();

        newStudent.setId((long) 123);
        newStudent.setStudentId(0);
        newStudent.setFirstName("John");
        newStudent.setLastName("Paul");
        newStudent.setAddressLine1("Kansas");
        newStudent.setAddressLine2("Kansas");
        newStudent.setAddressLine3("kansas");
        newStudent.setZipcode("66204");
        newStudent.setCourse("CSE");
        newStudent.setGender("M");
        newStudent.setState("Kansas");
        newStudent.setAge((long) 25);
        newStudent.setContactNumber("12356478900");
        newStudent.setEmail("sample@gmail.com");
        newStudent.setDateOfJoining(Instant.now());

        studentDetails.add(newStudent);
    }

    @AfterEach
    void tearDown() {
    }

    //@Test
    void createNewStudents() {

        List<NewStudentRequest> newStudentRequests = new ArrayList<NewStudentRequest>();

        NewStudentRequest newStudentRequest = new NewStudentRequest();
        newStudentRequest.setId(123L);
        newStudentRequest.setFirstName("John");
        newStudentRequest.setLastName("Paul");
        newStudentRequest.setAddressLine1("Kansas");
        newStudentRequest.setAddressLine2("Kansas");
        newStudentRequest.setAddressLine3("kansas");
        newStudentRequest.setZipCode("66204");
        newStudentRequest.setCourse("CSE");
        newStudentRequest.setGender("M");
        newStudentRequest.setState("Kansas");
        newStudentRequest.setAge(25L);
        newStudentRequest.setContactNumber("12356478900");
        newStudentRequest.setEmail("sample@gmail.com");

        newStudentRequests.add(newStudentRequest);

       // when(studentDetailsRepository.saveAll(studentDetails)).thenReturn(studentDetails);

        when(studentDetailsService.createNewStudents(newStudentRequests)).thenReturn(studentDetails);

        verify(studentDetailsRepository).saveAll(studentDetails);

        List<StudentDetails> actualResult = studentDetailsRepository.saveAll(studentDetails);

        System.out.println("+++++++++++" + actualResult);

        assertThat(actualResult.get(0).getFirstName()).isEqualTo(studentDetails.get(0).getFirstName());

    }

    @Test
    void getStudentByStudentID() {

    }

    @Test
    void getStudentById() {
    }

    @Test
    void getStudentByFirstName() {
    }

    @Test
    void deleteStudentByStudentID() {
    }
}