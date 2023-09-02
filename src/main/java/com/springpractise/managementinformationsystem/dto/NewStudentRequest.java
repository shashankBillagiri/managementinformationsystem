package com.springpractise.managementinformationsystem.dto;


import com.springpractise.managementinformationsystem.util.ValidateStudentGender;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewStudentRequest {

    private Long id;

    @NotBlank(message = "first name cannot be empty or null")
    private String firstName;

    @NotBlank(message = "last name cannot be empty or null")
    private String lastName;

    @ValidateStudentGender
    private String gender;

    @Min(18)
    @Max(60)
    @NotNull
    private Long age;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Please enter a Valid email")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Please enter a Valid Contact Number, A Valid Contact number should be 10 digits")
    private String contactNumber;

    private String addressLine1;

    private String addressLine2;

    private String addressLine3;

    private String state;

    private String zipcode;

    private String course;

}
