package com.springpractise.managementinformationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Table(name = "student_details")
public class StudentDetails implements Serializable {
    private static final long serialVersionUID = 1234567L;

    @Column(name = "id", columnDefinition = "number")
    private Long id;

    @Column(name = "first_name", columnDefinition = "varchar(30)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(30)")
    private String lastName;

    @Column(name = "gender", nullable = true)
    private String gender;

    @Column(name = "age")
    private Long age;

    @Column(name = "email", columnDefinition = "varchar(30)")
    private String email;

    @Column(name = "contact_number", columnDefinition = "varchar(30)")
    private String contactNumber;

    @Column(name = "address_Line1", columnDefinition = "varchar(30)")
    private String addressLine1;

    @Column(name = "address_Line2",  columnDefinition = "varchar(30)")
    private String addressLine2;

    @Column(name = "address_Line3",columnDefinition = "varchar(30)")
    private String addressLine3;

    @Column(name = "state",  columnDefinition = "varchar(30)")
    private String state;

    @Column(name = "Zipcode",columnDefinition = "varchar(100)")
    private String zipcode;

    @Column(name = "course", nullable = true)
    private String course;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentID", nullable = false)
    private long studentId;

    @Column(name = "Date_Of_Joining", nullable = false)
    private java.sql.Timestamp dateOfJoining;
}
