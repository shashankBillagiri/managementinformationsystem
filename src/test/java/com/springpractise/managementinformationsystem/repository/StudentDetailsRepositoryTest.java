package com.springpractise.managementinformationsystem.repository;

import com.springpractise.managementinformationsystem.entity.StudentDetails;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class StudentDetailsRepositoryTest {

    @Autowired
    private StudentDetailsRepository studentDetailsRepository;

    StudentDetails studentDetails;

    @BeforeEach
    void setUp() {
       /*studentDetails = new StudentDetails((long) 1,"John","Paul","M",(long)32,"jp@gmail.com",
               "1234567791","khammam","khammam","khammam","TELANGANA","97005",
               "CSE",723773, Instant.now());*/

        studentDetails = StudentDetails.builder()
                .id((long) 1)
                .addressLine1("OVERLANDPARK")
                .addressLine2("OVERLANDPARK")
                .addressLine3("OVERLANDPARK")
                .studentId(700701)
                .age((long) 25)
                .dateOfJoining(Instant.now())
                .firstName("John")
                .lastName("Paul")
                .contactNumber("1234")
                .state("Kansas")
                .zipcode("66204")
                .email("sample@gmail.com")
                .course("CSE")
                .gender("F")
                .build();


        //studentDetailsRepository.save(studentDetails);
    }


    @AfterEach
    void tearDown() {
        studentDetails = null;
        //studentDetailsRepository.deleteAll();
    }


    @Test
    void testFindByFirstName_Found() {
        StudentDetails students= new StudentDetails();
        students.setStudentId(9999);
        studentDetailsRepository.save(students);

    }



}


