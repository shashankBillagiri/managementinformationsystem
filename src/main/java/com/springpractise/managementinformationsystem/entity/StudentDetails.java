package com.springpractise.managementinformationsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "student_details")
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetails {

    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "address_Line1")
    private String addressLine1;

    @Column(name = "address_Line2")
    private String addressLine2;

    @Column(name = "address_Line3")
    private String addressLine3;

    @Column(name = "state")
    private String state;

    @Column(name = "Zipcode")
    private String zipcode;

    @Column(name = "course")
    private String course;

    @Id
    @Column(name = "StudentiD")
    private long studentId;

    @Column(name = "Date_Of_Joining")
    private java.sql.Timestamp dateOfJoining;
}
