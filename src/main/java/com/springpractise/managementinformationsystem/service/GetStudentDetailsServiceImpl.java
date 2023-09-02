package com.springpractise.managementinformationsystem.service;

import com.springpractise.managementinformationsystem.dto.StudentDetailsResponse;
import com.springpractise.managementinformationsystem.entity.StudentDetails;
import com.springpractise.managementinformationsystem.mapper.StudentDetailsMapper;
import com.springpractise.managementinformationsystem.repository.StudentDetailsRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetStudentDetailsServiceImpl implements GetStudentDetailsService {

    @Autowired
    private StudentDetailsRepository studentDetailsRepository;

    @Autowired
    private StudentDetailsMapper studentDetailsMapper;


    @Override
    public StudentDetailsResponse getStudentDetails(Integer pageNumber, Integer pageSize, HttpServletRequest request) {
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by("studentId").descending());
        Page<StudentDetails> recordsPage = studentDetailsRepository.findAll(paging);
        List<StudentDetails> studentDetail = recordsPage.getContent();
        return studentDetailsMapper.map(studentDetail, pageNumber, pageSize, (int) recordsPage.getTotalElements(), request);
    }
}