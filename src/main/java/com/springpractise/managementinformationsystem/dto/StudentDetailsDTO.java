package com.springpractise.managementinformationsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDetailsDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String contactNumber;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String state;
    private String zipcode;
    private String course;
    private Integer studentId;
    private String dateOfJoining;
    private LocalDate age;
}
