package com.springpractise.managementinformationsystem.util;

import java.util.Arrays;
import java.util.List;

public final class MISConstants {

    public static final String DUPLICATE_ID = "There is a student Existing id %d , Please check the Id";

    public static final String INVALID_COURSE = "Course should be either of ECE OR CSE OR EEE OR CIVIL OR MECH";

    public static final String STUDENTS_DO_NOT_EXIST = "There are no Students with given first name  %s in the records";

    public static final List<String> VALID_COURSES = Arrays.asList("ECE", "CSE", "EEE","CIVIL","MECH");
}
