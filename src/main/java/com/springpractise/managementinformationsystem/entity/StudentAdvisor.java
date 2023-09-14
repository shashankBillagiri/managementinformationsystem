package com.springpractise.managementinformationsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student_advisor")
public class StudentAdvisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advisorid", unique = true)
    private long advisorId;

    @Column(name = "firstname", columnDefinition ="varchar(20)")
    private String firstName;

    @Column(name = "lastname", columnDefinition ="varchar(20)")
    private String lastName;
}
