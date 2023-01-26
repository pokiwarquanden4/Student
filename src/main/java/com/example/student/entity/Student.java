package com.example.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "Student")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Student_ID")
    private Long id;
    @Column(name = "Student_Name")
    private String name;
    @Column(name = "Student_Age")
    private int age;
    @Column(name = "Date_Of_Birth")
    private Date dateOfBirth;
    @Column(name = "Student_Phonenumber")
    private String phoneNumber;
    @Column(name = "Create_Time")
    private Date createTime;
    @Column(name = "Update_Time")
    private Date updateTime;

    public Student(String name, int age, Date dateOfBirth, String phoneNumber, Date createTime, Date updateTime) {
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
