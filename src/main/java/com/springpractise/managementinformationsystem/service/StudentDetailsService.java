package com.springpractise.managementinformationsystem.service;

import com.springpractise.managementinformationsystem.entity.StudentDetails;
import com.springpractise.managementinformationsystem.model.NewStudentRequest;
import com.springpractise.managementinformationsystem.repository.StudentDetailsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class StudentDetailsService {

    private  final StudentDetailsRepository studentDetailsRepository;

//    public StudentDetailsService(StudentDetailsRepository studentDetailsRepository) {
//        this.studentDetailsRepository = studentDetailsRepository;
//    }


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
        return  studentDetailsRepository.findByStudentId(studentId);
    }

    public int getStudentById(Long id) {
        int id1 = Math.toIntExact(id);
        return studentDetailsRepository.findByid(id1).size();
    }

    public List<StudentDetails> getStudentByFirstName(String firstName) {
        return studentDetailsRepository.findByFirstName(firstName);
    }


    @Transactional
    public List<StudentDetails> deleteStudentByStudentID(List<Long> studentIds) {

       return studentDetailsRepository.deleteByStudentIdIn(studentIds);
    }

}
