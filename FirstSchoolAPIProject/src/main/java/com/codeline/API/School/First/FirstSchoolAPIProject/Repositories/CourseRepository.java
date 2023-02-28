package com.codeline.API.School.First.FirstSchoolAPIProject.Repositories;

import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Course;
import com.codeline.API.School.First.FirstSchoolAPIProject.Models.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository// Collection of code that is going to be used for the Objects
// to speak to database and give data to service

public interface CourseRepository extends CrudRepository<Course, Integer> {

    @Query("SELECT c from Course c")

    List<Course> getAllCourse();

    @Query("SELECT c from Course c where c.id= :courseId")
    // :id is coming from the user
    Course getCourseById(@Param("courseId") Integer id);

    @Query("SELECT c from Course c where c.name= :courseName")
    Course getCourseByName(@Param("courseName") String course_name); // mapping the query and returning the Course


    @Query(value = "SELECT c from Course c where c.isActive = true")
    List<Course> getAllActiveCourse();

    @Query(value = "SELECT c from Course c where c.isActive = false")
    List<Course> getAllNotActiveCourse();
}
