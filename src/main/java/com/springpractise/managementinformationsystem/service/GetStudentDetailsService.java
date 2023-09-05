package com.springpractise.managementinformationsystem.service;

import com.springpractise.managementinformationsystem.model.StudentDetailsResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public interface GetStudentDetailsService {


    StudentDetailsResponse getStudentDetails(Integer pageNumber, Integer pageSize, HttpServletRequest request) ;
}
