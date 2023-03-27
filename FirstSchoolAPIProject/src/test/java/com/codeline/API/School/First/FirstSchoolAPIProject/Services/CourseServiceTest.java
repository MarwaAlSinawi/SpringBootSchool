package com.codeline.API.School.First.FirstSchoolAPIProject.Services;

import com.codeline.API.School.First.FirstSchoolAPIProject.Controlles.CourseController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseServiceTest {
 @Autowired
    CourseController courseController;
    @Test
    void getAllCourse() {
    }

    @Test
    void getCourseById() throws Exception{
        String CourseName = courseController.getCourseById(12).getName();
        assertEquals("Java",CourseName);
        }
   @Test
   void getCourseById1() throws Exception{
      String CourseName = courseController.getCourseById(1).getName();
      assertEquals("C++",CourseName);
   }
   @Test
   void getCourseById2() throws Exception{
      String CourseName = courseController.getCourseById(2).getName();
      assertEquals("paython",CourseName);
   }
   @Test
   void getCourseById3() throws Exception{
      String CourseName = courseController.getCourseById(3).getName();
      assertEquals("php",CourseName);
   }



    @Test
    void getCoursesByName() {
    }

    @Test
    void getAllActiveCourse() {
    }

    @Test
    void getAllNotActiveCourse() {
    }

    @Test
    void getLatestRow() {
    }

    @Test
    void deleteAllCourses() {
    }

    @Test
    void deleteCourseById() {
    }

    @Test
    void deleteAllCoursesCreatedAfterDate() {
    }

    @Test
    void getAllActiveCoursesForAStudent() {
    }

    @Test
    void getCoursesByStudentId() {
    }

    @Test
    void getLatestUpdatedDate() {
    }

    @Test
    void deleteCoursesByName() {
    }

    @Test
    void deleteCoursesByCreatedDate() {
    }

    @Test
    void getCoursesByCreatedDate() {
    }

    @Test
    void getCoursesByUpdatedDate() {
    }

    @Test
    void getCoursesCreatedAfterDate() {
    }

    @Test
    void updateCourse() {
    }

    @Test
    void createCourse() {
    }
}