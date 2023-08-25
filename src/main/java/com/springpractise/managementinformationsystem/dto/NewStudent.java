package com.springpractise.managementinformationsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewStudent {

    private Long id;

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

    private java.sql.Timestamp dateOfJoining;
}
