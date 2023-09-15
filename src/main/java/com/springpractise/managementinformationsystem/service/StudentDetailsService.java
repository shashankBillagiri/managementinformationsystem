package com.springpractise.managementinformationsystem.service;

import com.springpractise.managementinformationsystem.entity.StudentDetails;
import com.springpractise.managementinformationsystem.model.NewStudentRequest;
import com.springpractise.managementinformationsystem.repository.StudentDetailsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentDetailsService {

    @Autowired
    private StudentDetailsRepository studentDetailsRepository;


    public List<StudentDetails> createNewStudents(List<NewStudentRequest> NewStudentRequests) {

        List<StudentDetails> studentDetails = new ArrayList<>();

        for (NewStudentRequest NewStudentRequest : NewStudentRequests) {

            StudentDetails studentDetailsObject = StudentDetails
                    .build(NewStudentRequest.getId(), NewStudentRequest.getFirstName(), NewStudentRequest.getLastName(), NewStudentRequest.getGender(), NewStudentRequest.getAge(), NewStudentRequest.getEmail(), NewStudentRequest.getContactNumber(), NewStudentRequest.getAddressLine1(), NewStudentRequest.getAddressLine2(), NewStudentRequest.getAddressLine3(), NewStudentRequest.getState(), NewStudentRequest.getZipCode(), NewStudentRequest.getCourse(), 0, Instant.now());

            studentDetails.add(studentDetailsObject);
        }

        return studentDetailsRepository.saveAll(studentDetails);
    }


    public StudentDetails getStudentByStudentID(Long studentId) {
        StudentDetails studentDetails = studentDetailsRepository.findByStudentId(studentId);
        return studentDetails;
    }

    public int getStudentById(Long id) {
        Integer id1 = Math.toIntExact(id);
        int count = studentDetailsRepository.findByid(id1).size();
        return count;
    }

    public List<StudentDetails> getStudentByFirstName(String firstName) {
        List<StudentDetails> studentDetails = studentDetailsRepository.findByFirstName(firstName);
        return studentDetails;
    }


    @Transactional
    public void deleteStudentByStudentID(List<Long> studentIds) {

        studentDetailsRepository.deleteByStudentIdIn(studentIds);
    }

}
