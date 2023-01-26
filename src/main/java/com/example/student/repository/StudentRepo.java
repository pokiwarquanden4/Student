package com.example.student.repository;

import com.example.student.entity.Student;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM student", nativeQuery = true)
    List<Student> getAllStudent();

    @Query(value = "SELECT * FROM student WHERE Student_Age > 10", nativeQuery = true)
    List<Student> getUpTen_Student();

    @Query(value = "SELECT * FROM student WHERE Student_Age < 10", nativeQuery = true)
    List<Student> getDownTen_Student();
}
