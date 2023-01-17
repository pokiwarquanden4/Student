package com.example.student.repository;

import com.example.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Map;
import java.util.Objects;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM Student", nativeQuery = true)
    Map<Objects, Objects> getAllStudent();

    @Query(value = "INSERT INTO table_name (Student_Name, Date_Of_Birth, Student_Phonenumber, Create_Time, Update_Time)\n" +
            "VALUES (:name, :dateOfBirth, :phoneNumber, :createTime, :updateTime);", nativeQuery = true)
    void createStudent(@Param("name") String name, @Param("dateOfBirth") Calendar dateOfBirth, @Param("phoneNumber") String phoneNumber, @Param("createTime") Calendar createTime, @Param("updateTime") Calendar updateTime);
}
