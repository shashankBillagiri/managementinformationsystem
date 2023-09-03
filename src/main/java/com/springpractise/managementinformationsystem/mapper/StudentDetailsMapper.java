package com.springpractise.managementinformationsystem.mapper;

import com.springpractise.managementinformationsystem.dto.StudentDetailsResponse;
import com.springpractise.managementinformationsystem.dto.StudentInfo;
import com.springpractise.managementinformationsystem.entity.StudentDetails;
import com.springpractise.managementinformationsystem.util.DateUtility;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentDetailsMapper {

    public StudentDetailsResponse map(List<StudentDetails> studentDetails, Integer pageNumber, Integer pageSize, Integer totalStudents, HttpServletRequest request){


        StudentDetailsResponse studentDetailsResponse = new StudentDetailsResponse();

        List<StudentInfo> studentInformation = new ArrayList<>();

        studentDetails.stream().forEach(StudentDetails ->{


            StudentInfo studentInfo = StudentInfo.builder()
                    .id(StudentDetails.getId())
                    .firstName(StudentDetails.getFirstName())
                    .lastName(StudentDetails.getLastName())
                    .gender(StudentDetails.getGender())
                    .email(StudentDetails.getEmail())
                    .contactNumber(StudentDetails.getContactNumber())
                    .addressLine1(StudentDetails.getAddressLine1())
                    .addressLine2(StudentDetails.getAddressLine2())
                    .addressLine3(StudentDetails.getAddressLine3())
                    .state(StudentDetails.getState())
                    .zipcode(StudentDetails.getZipcode())
                    .course(StudentDetails.getCourse())
                    .studentId(StudentDetails.getStudentId())
                    .dateOfJoining(DateUtility.toDate(StudentDetails.getDateOfJoining()))
                    .age(StudentDetails.getAge())
                    .build();

            studentInformation.add(studentInfo);

            studentDetailsResponse.setStudentDetails(studentInformation);

        });

        studentDetailsResponse.setPageNumber(pageNumber);

        studentDetailsResponse.setPageSize(pageSize);

        studentDetailsResponse.setTotalStudents(totalStudents);

        studentDetailsResponse.setPath(request.getServletPath());

        return studentDetailsResponse;


    }
}
