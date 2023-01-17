package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.model.ResponseStudent;
import com.example.student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepo studentRepo;

    @GetMapping("")
    public ResponseEntity<ResponseStudent> getALlStudent(){
        Map<Objects, Objects> student =studentRepo.getAllStudent();
        return student.isEmpty() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseStudent("false", "Cannot get all student" , "")
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseStudent("true", "Get All Student Successfully" , student)
                );
    }

    @PostMapping("")
    public ResponseEntity<ResponseStudent> createStudent(@RequestBody Student student){
        studentRepo.createStudent(student.getName(), student.getDateOfBirth(), student.getPhoneNumber(), student.getCreateTime(), student.getUpdateTime());
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseStudent("ok", "Create Successfully", "")
        );
    }
}
