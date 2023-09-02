package com.springpractise.managementinformationsystem.dto;

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

    private List<StudentInfo> studentDetails;
    private Integer pageSize;
    private Integer pageNumber;
    private Integer totalStudents;
    private String path;
}
