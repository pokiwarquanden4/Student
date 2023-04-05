package com.example.student.controller;

import com.example.student.entity.Report;
import com.example.student.entity.Student;
import com.example.student.model.JSONStudent;
import com.example.student.model.ResponseStudent;
import com.example.student.repository.ReportRepo;
import com.example.student.repository.StudentRepo;
import com.example.student.service.DateSerivce;
import com.example.student.service.ReportService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
@EnableScheduling
@Transactional
public class StudentController {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    ReportRepo reportRepo;
    @Autowired
    ReportService reportService;

    @GetMapping("")
    public ResponseEntity<ResponseStudent> getALlStudent(){
        List<Student> student =studentRepo.findAll();
        return student.isEmpty() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseStudent("false", "Cannot get all student" , "")
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseStudent("true", "Get All Student Successfully" , student)
                );
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseStudent> createStudent(@RequestBody JSONStudent jsonStudent){
        Student student = new Student(jsonStudent.getName(),jsonStudent.getAge(), DateSerivce.converDate(jsonStudent.getDateOfBirth()), jsonStudent.getPhoneNumber(), DateSerivce.converDate(jsonStudent.getCreateTime()), DateSerivce.converDate(jsonStudent.getUpdateTime()));
        studentRepo.save(student);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseStudent("ok", "Create Successfully", "")
        );
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ResponseStudent> createStudent(@PathVariable("id") String id){
        studentRepo.deleteById(Long.parseLong(id));
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseStudent("ok", "Create Successfully", "")
        );
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ResponseStudent> updateStudent(@PathVariable("id") Long id, @RequestBody JSONStudent jsonStudent){
        Student student = studentRepo.findByAge(12);
        student.setName(jsonStudent.getName());

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseStudent("ok", "Create Successfully", "")
        );
    }
}

