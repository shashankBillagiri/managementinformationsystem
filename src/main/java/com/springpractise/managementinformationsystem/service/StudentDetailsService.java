package com.springpractise.managementinformationsystem.service;

import com.springpractise.managementinformationsystem.entity.StudentDetails;
import com.springpractise.managementinformationsystem.repository.StudentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDetailsService {

    @Autowired
    private StudentDetailsRepository studentDetailsRepository;


    public List<StudentDetails> getStudentDetails() {
        List<StudentDetails> studentDetails = studentDetailsRepository.findAll();
        studentDetails.forEach(System.out::println);
        return studentDetails;
    }


    public List<StudentDetails> createNewStudents(List<StudentDetails> newStudents) {
        return studentDetailsRepository.saveAll(newStudents);
    }

    public StudentDetails createNewStudent(StudentDetails newStudent) {
        return studentDetailsRepository.save(newStudent);
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
