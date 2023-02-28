package com.codeline.API.School.First.FirstSchoolAPIProject.Repositories;

import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Collection of code that is going to be used for the Objects
// to speak to database and give data to service

public interface StudentRepository extends CrudRepository<Student, Integer> { // The class is dealing with student and the primary key in Integer
// using inheritance

    @Query("SELECT s from Student s")
    List<Student> getAllStudent();

    @Query("SELECT s from Student s where s.id= :studentId")
        // :id is coming from the user

    Student getStudentById(@Param("studentId") Integer id);

    @Query("SELECT s from Student s where s.name= :name")
    Student getStudentByName(@Param("name") String student_name);

    @Query(value = "SELECT std from Student std WHERE std.school.id = :id ")
    List<Student> getStudentsBySchoolId(@Param("id") Integer id);
}