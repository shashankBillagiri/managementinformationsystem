package com.springpractise.managementinformationsystem.repository;

import com.springpractise.managementinformationsystem.entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetails,Integer> {

    List<StudentDetails> findByid(long id);

    List<StudentDetails> findByFirstName(String firstName);


    StudentDetails findByStudentId(long studentId);

    void deleteByStudentIdIn(List<Long> studentIds);
}
