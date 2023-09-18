package com.springpractise.managementinformationsystem.service;

import com.springpractise.managementinformationsystem.entity.StudentDetails;
import com.springpractise.managementinformationsystem.mapper.StudentDetailsMapper;
import com.springpractise.managementinformationsystem.repository.StudentDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class GetStudentDetailsServiceImplTest {

    @Mock
    private  StudentDetailsRepository studentDetailsRepository;
    @Mock
    private StudentDetailsMapper studentDetailsMapper;

    @Autowired
    private GetStudentDetailsService getStudentDetailsService;

    StudentDetails studentDetails;




    @BeforeEach
    void setUp() {


       // getStudentDetailsService = new GetStudentDetailsServiceImpl(studentDetailsRepository,studentDetailsMapper);

        studentDetails = new StudentDetails();

        studentDetails.setId((long) 123);
        studentDetails.setStudentId(9999);
        studentDetails.setFirstName("John");
        studentDetails.setLastName("Paul");
        studentDetails.setAddressLine1("Kansas");
        studentDetails.setAddressLine2("Kansas");
        studentDetails.setAddressLine3("kansas");
        studentDetails.setZipcode("66204");
        studentDetails.setCourse("CSE");
        studentDetails.setGender("M");
        studentDetails.setState("Kansas");
        studentDetails.setAge((long)25);
        studentDetails.setContactNumber("12356478900");
        studentDetails.setEmail("sample@gmail.com");
        studentDetails.setDateOfJoining(Instant.now());

        studentDetailsRepository.save(studentDetails);
    }


    @Test
    void TestGetStudentDetailsWithoutPagination() {



    }
}