package com.example.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Entity
@Table(name = "Student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @Column(name = "Student_ID")
    private Long id;
    @Column(name = "Student_Name")
    private String name;
    @Column(name = "Date_Of_Birth")
    private Calendar dateOfBirth;
    @Column(name = "Student_Phonenumber")
    private String phoneNumber;
    @Column(name = "Create_Time")
    private Calendar createTime;
    @Column(name = "Update_Time")
    private Calendar updateTime;
}
