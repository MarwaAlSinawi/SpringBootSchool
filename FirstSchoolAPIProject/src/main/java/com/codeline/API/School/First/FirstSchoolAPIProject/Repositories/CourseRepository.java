package com.codeline.API.School.First.FirstSchoolAPIProject.Repositories;

import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Course;
import com.codeline.API.School.First.FirstSchoolAPIProject.Models.School;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
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
    List<Course> getCourseByName(@Param("courseName") String course_name); // mapping the query and returning the Course




    @Query(value = "SELECT c from Course c where c.isActive = true")
    List<Course> getAllActiveCourse();

    @Query(value = "SELECT c from Course c where c.isActive = false")
    List<Course> getAllNotActiveCourse();


    @Query(value = "select * from Course  where id = (select Max(id) from course)",nativeQuery = true)
    Course getLatestRow();

    @Modifying
    @Transactional
    @Query(value = "update Course c Set c.isActive = false")
    void deleteAllCourses();

    @Query(value = "select c from Course c where c.createdDate >=  :createdDate")
    List<Course> deleteAllCoursesCreatedAfterDate(Date createdDate);

    @Query(value = "select c from Course c where c.student.id = :studentId and (c.isActive=1)")
    List<Course> getAllActiveCoursesForAStudent(Integer studentId);

    @Query(value = "select c from Course c where c.student.id = :studentId")
    List<Course> getCoursesByStudentId(@Param("studentId") Integer id);

   @Query(value = " select * from Course  where updated_date = (select Max(updated_date) from Course )", nativeQuery = true)
    Course getLatestUpdatedDate();
  @Query(value = "select * from course where created_date like CONCAT (?1, '%') ", nativeQuery = true)
  List<Course> getCourseByCreatedDate(String createdDate);

    @Query(value = "select * from course where updated_date like CONCAT (?1, '%') ", nativeQuery = true)
    List<Course> getCourseByUpdatedDate(String updatedDate);

    @Query(value = "select c from Course c where c.createdDate > :createdDate")
    List<Course> getCourseCreatedAfterDate(@Param("createdDate") Date createdDate);




}
