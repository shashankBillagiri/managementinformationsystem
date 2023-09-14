package com.springpractise.managementinformationsystem.repository;

import com.springpractise.managementinformationsystem.entity.StudentDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertNull;


@DataJpaTest
class StudentDetailsRepositoryTest {


    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private StudentDetailsRepository studentDetailsRepository;

    StudentDetails studentDetails;


    @BeforeEach
    void setUp() {

        studentDetails = StudentDetails.builder()
                .id((long) 12345)
                .addressLine1("OVERLANDPARK")
                .addressLine2("OVERLANDPARK")
                .addressLine3("OVERLANDPARK")
                .age((long) 25)
                .dateOfJoining(Instant.now())
                .firstName("JOHN")
                .lastName("Paul")
                .contactNumber("1234")
                .state("Kansas")
                .zipcode("66204")
                .email("sample@gmail.com")
                .course("CSE")
                .gender("F")
                .build();

        testEntityManager.persist(studentDetails);
        testEntityManager.flush();

    }


    @Test
    void testFindByFirstName_Found() {
        List<StudentDetails> students = studentDetailsRepository.findByFirstName("JOHN");
        assertThat(students).isNotEmpty();
        assertThat((students.get(0).getFirstName()).equalsIgnoreCase("John"));
    }


    @Test
    void testFindByFirstName_NotFound() {
        List<StudentDetails> students = studentDetailsRepository.findByFirstName("Kathy");
        assertThat(students).isEmpty();
    }

    @Test
    void testFindById_Found() {

        List<StudentDetails> students = studentDetailsRepository.findByid(12345);
        assertThat(students).isNotEmpty();
        assertThat(students.get(0).getFirstName().equalsIgnoreCase("John"));

    }

    @Test
    void testFindById_NOTFound() {
        List<StudentDetails> studentDetails = studentDetailsRepository.findByid(1234);
        assertThat(studentDetails).isEmpty();
    }

    @Test
    void testFindByStudentId_Found() {

        StudentDetails students = studentDetailsRepository.findByStudentId(studentDetails.getStudentId());
        assertThat(students.getFirstName().equalsIgnoreCase("JOHN"));
    }

    @Test
    void testFindByStudentId_NotFound() {

        StudentDetails studentDetails = studentDetailsRepository.findByStudentId(12345);
        assertNull("studentdetails is Null",studentDetails);
    }

}



