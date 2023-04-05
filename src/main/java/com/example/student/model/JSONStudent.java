package com.example.student.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JSONStudent {
    private String name;
    private int age;
    private String dateOfBirth;
    private String phoneNumber;
    private String createTime;
    private String updateTime;
}
