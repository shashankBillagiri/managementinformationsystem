package com.springpractise.managementinformationsystem.service;

import com.springpractise.managementinformationsystem.dto.NewStudentRequest;
import com.springpractise.managementinformationsystem.entity.StudentDetails;
import com.springpractise.managementinformationsystem.repository.StudentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class StudentDetailsService {

    @Autowired
    private StudentDetailsRepository studentDetailsRepository;


    public Page<StudentDetails> getStudentDetails(Pageable paging) {
        Page<StudentDetails> studentDetails = studentDetailsRepository.findAll(paging);
        //studentDetails.forEach(System.out::println);
        return studentDetails;
    }


    public List<StudentDetails> createNewStudents(List<StudentDetails> newStudents) {
        return studentDetailsRepository.saveAll(newStudents);
    }

    public StudentDetails createNewStudent(NewStudentRequest newStudentRequest) {
        StudentDetails studentDetails = StudentDetails
                .build(newStudentRequest.getId(), newStudentRequest.getFirstName(), newStudentRequest.getLastName(), newStudentRequest.getGender(), newStudentRequest.getAge(), newStudentRequest.getEmail(), newStudentRequest.getContactNumber(), newStudentRequest.getAddressLine1(), newStudentRequest.getAddressLine2(), newStudentRequest.getAddressLine3(), newStudentRequest.getState(), newStudentRequest.getZipcode(), newStudentRequest.getCourse(),0 , Instant.now() );
        return studentDetailsRepository.save(studentDetails);
    }


    public  StudentDetails getStudentByStudentID(Long id){
        Integer id1 = Math.toIntExact(id);
        StudentDetails studentDetails = studentDetailsRepository.findById(id1).get();
        return studentDetails;
    }

    public  int getStudentById(Long id){
        Integer id1 = Math.toIntExact(id);
        int count = studentDetailsRepository.findByid(id1).size();
        return count;
    }

    public  List<StudentDetails> getStudentByFirstName(String firstName){
        List<StudentDetails> studentDetails = studentDetailsRepository.findByFirstName(firstName);
        return studentDetails;
    }

}
