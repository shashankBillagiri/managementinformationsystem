package com.springpractise.managementinformationsystem.service;

import com.springpractise.managementinformationsystem.entity.StudentDetails;
import com.springpractise.managementinformationsystem.mapper.StudentDetailsMapper;
import com.springpractise.managementinformationsystem.model.StudentDetailsResponse;
import com.springpractise.managementinformationsystem.repository.StudentDetailsRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetStudentDetailsServiceImpl implements GetStudentDetailsService {

    private final StudentDetailsRepository studentDetailsRepository;

    private final StudentDetailsMapper studentDetailsMapper;


    @Override
    public StudentDetailsResponse getStudentDetails(Integer pageNumber, Integer pageSize, HttpServletRequest request) {

        Pageable pageable ;

        if (pageSize == 0) {
            pageable = Pageable.unpaged();
        } else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by("studentId").descending());
        }
        Page<StudentDetails> recordsPage = studentDetailsRepository.findAll(pageable);
        List<StudentDetails> studentDetail = recordsPage.getContent();
        return studentDetailsMapper.map(studentDetail, pageNumber, pageSize, (int) recordsPage.getTotalElements(), request);
    }
}
