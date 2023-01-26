package com.example.student.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DateSerivce {
    public static Date converDate(String stringDate) {
        Date date = new Date();
        String[] arr = stringDate.split("/");
        date.setDate(Integer.parseInt(arr[0]));
        date.setMonth(Integer.parseInt(arr[1]));
        date.setYear(Integer.parseInt(arr[2]));
        System.out.println(date);
        return date;
    }
}
