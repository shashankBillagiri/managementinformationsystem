package com.springpractise.managementinformationsystem.mapper;

import com.springpractise.managementinformationsystem.entity.StudentDetails;
import com.springpractise.managementinformationsystem.model.StudentDetailsResponse;
import com.springpractise.managementinformationsystem.model.StudentInfo;
import com.springpractise.managementinformationsystem.util.DateUtility;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class StudentDetailsMapper {

    public StudentDetailsResponse map(List<StudentDetails> studentDetails, Integer pageNumber, Integer pageSize, Integer totalStudents, HttpServletRequest request) {


        StudentDetailsResponse studentDetailsResponse = new StudentDetailsResponse();

        List<StudentInfo> studentInformation = new ArrayList<>();

        studentDetails.stream().forEach(StudentDetails -> {


            StudentInfo studentInfo = StudentInfo.builder()
                    .id(StudentDetails.getId())
                    .firstName(StudentDetails.getFirstName().trim().toUpperCase())
                    .lastName(StudentDetails.getLastName().trim().toUpperCase())
                    .gender(StudentDetails.getGender().toUpperCase())
                    .email(StudentDetails.getEmail().toUpperCase())
                    .contactNumber(StudentDetails.getContactNumber())
                    .addressLine1(StudentDetails.getAddressLine1().toUpperCase())
                    .addressLine2(StudentDetails.getAddressLine2().toUpperCase())
                    .addressLine3(StudentDetails.getAddressLine3().toUpperCase())
                    .state(StudentDetails.getState().toUpperCase())
                    .zipcode(StudentDetails.getZipcode().trim())
                    .course(Objects.nonNull(StudentDetails.getCourse()) ? StudentDetails.getCourse() : "")
                    .studentId(StudentDetails.getStudentId())
                    .dateOfJoining(DateUtility.toDate(StudentDetails.getDateOfJoining()))
                    .age(Objects.nonNull(StudentDetails.getAge()) ? StudentDetails.getAge() : 0)
                    .build();

            studentInformation.add(studentInfo);


        });

        studentDetailsResponse.setStudentDetails(studentInformation);

        studentDetailsResponse.setPageNumber(pageNumber);

        studentDetailsResponse.setPageSize(pageSize);

        studentDetailsResponse.setTotalStudents(totalStudents);

        studentDetailsResponse.setPath(request.getServletPath());

        return studentDetailsResponse;


    }
}
