package com.codeline.API.School.First.FirstSchoolAPIProject.Repositories;


import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Collection of code that is going to be used for the Objects
// to speak to database and give data to service

public interface StudentRepository extends JpaRepository<Student, Integer> { // The class is dealing with student and the primary key in Integer
// using inheritance

    @Query("SELECT s from Student s")
    List<Student> getAllStudent();

    @Query("SELECT s from Student s where s.id= :studentId")
        // :id is coming from the user

    Student getStudentById(@Param("studentId") Integer id);

    @Query("SELECT s from Student s where s.name =:name")
    Student getStudentByName(@Param("name") String student_name);

    @Query(value = "SELECT std from Student std WHERE std.school.id = :id ")
    List<Student> getStudentsBySchoolId(@Param("id") Integer id);

    @Query(value = "SELECT s from Student s where s.isActive = true")
    List<Student> getAllActiveStudent();

    @Query(value = "SELECT s from Student s where s.isActive = false")
    List<Student> getAllNotActiveStudent();

    @Query(value = "SELECT DISTINCT s.school.id FROM Student s")
    List<Integer> getDistinctSchoolIdsFromStudent();

    @Query(value = "SELECT COUNT(id) From student where school_id = ?1", nativeQuery = true)
    Integer getCountOfStudentsBySchoolId(Integer schoolId);

    @Query(value = "select st from Student st where st.id = (select Max(st.id) from Student st )")
    Student getLatestRow();

    @Query(value = " select * from Student  where updated_date = (select Max(updated_date) from Student )", nativeQuery = true)
    Student getLatestUpdatedDate();

    @Query(value = "select st from Student st where st.createdDate >= '2022-02-25'")
    List<Student> getStudentCreatedAfterDate();

    @Query(value = "select st from Student st where st.name = :name")
    Student getStudentByStudentName(@Param("name") String name);

    //@Query(value = "select st from Student st where st.studentRollNumber = :studentRollNumber")
   // Student getByStudentByRollNumber(Integer studentRollNumber);

    @Query(value = "select st from Student st where st.school.id = :schoolId")
    List<Student> getStudentBySchoolId(@Param("schoolId") Integer id);

}
