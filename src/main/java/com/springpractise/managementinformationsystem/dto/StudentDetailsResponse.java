package com.springpractise.managementinformationsystem.dto;

import com.springpractise.managementinformationsystem.entity.StudentDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetailsResponse {

    private List<StudentDetails> studentDetails;
    private Integer pageSize;
    private Integer pageNumber;
    private Integer totalStudents;
    private String path;
}
