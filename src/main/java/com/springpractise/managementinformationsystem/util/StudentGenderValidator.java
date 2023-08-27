package com.springpractise.managementinformationsystem.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class StudentGenderValidator implements ConstraintValidator<ValidateStudentGender,String> {
    @Override
    public boolean isValid(String gender, ConstraintValidatorContext context) {
        List<String>  validGender = Arrays.asList("F","M");
        return validGender.contains(gender);
    }
}
