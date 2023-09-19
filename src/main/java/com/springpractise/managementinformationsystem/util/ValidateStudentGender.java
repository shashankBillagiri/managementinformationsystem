package com.springpractise.managementinformationsystem.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = StudentGenderValidator.class)
public @interface ValidateStudentGender {

    String message() default "Gender should be either M  OR F";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
