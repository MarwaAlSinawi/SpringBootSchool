package com.codeline.API.School.First.FirstSchoolAPIProject.Repositories;

import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Mark;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Collection of code that is going to be used for the Objects
// to speak to database and give data to service

public interface MarkRepository extends CrudRepository<Mark, Integer> {

    @Query("SELECT m from Mark m")
    List<Mark> getAllMarks();

    @Query("SELECT m from Mark m where m.id= :markId")
        // :id is coming from the user

    Mark getMarkById(@Param("markId") Integer id);

    @Query(value = "SELECT m from Course m where m.isActive = true")
    List<Mark> getAllActiveMark();

    @Query(value = "SELECT m from Course m where m.isActive = false")
    List<Mark> getAllNotActiveMark();

    @Query(value = "select sum(m.obtainMark) from Mark m where m.course.student.id = :studentId ")
    Integer getSumOfMarksByStudentId(@Param("studentId") Integer studentId);

    @Query(value = "select avg(m.obtainMark) from Mark m where m.course.student.id = :studentId ")
    Integer getAvgMarkByStudentId(@Param("studentId") Integer studentId);

    @Query(value = " select count(m) from Mark m where m.course.name = :courseName And m.grade = :grade ")
    Integer getCountOfMarksByGradeAndCourseName( @Param("courseName") String courseName,@Param("grade") String grade);

    @Query(value = " select Distinct(m.grade) from Mark m ")
    List<String> getDistinctGrades();

    @Query(value = " select avg(m.obtainMark) from Mark m where m.course.id =:courseId ")
    Integer averageMarkForCourse(@Param("courseId") Integer courseId);

    @Query(value = "select count(m.course.student.id) from Mark m where m.obtainMark > :courseThreshold AND m.course.name = :courseName")
    Integer countOfStudentsHavingHighScoreInCourse (@Param("courseThreshold") Integer courseThreshold, @Param("courseName") String courseName);

    @Query(value = "select avg(m.obtainMark) from Mark m where m.course.student.school.id  = :schoolId ")
    Integer getAvgOfMarksBySchoolId(@Param("schoolId") Integer schoolId);

}

