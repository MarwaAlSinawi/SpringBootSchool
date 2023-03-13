package com.codeline.API.School.First.FirstSchoolAPIProject.Services;

import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Course;
import com.codeline.API.School.First.FirstSchoolAPIProject.Models.School;
import com.codeline.API.School.First.FirstSchoolAPIProject.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service // this is where everything is going to be done related to the object such as function and many more
// To give controller whatever it needs
public class CourseService {

    @Autowired // create instance, and then it can be used in all the program
    CourseRepository courseRepository;


    //function that gets all the school
    public List<Course> getAllCourse() {
        return courseRepository.getAllCourse();
    }

    public Course getCourseById(Integer id) {
        Course course = courseRepository.getCourseById(id);
        return course;
    }

//    public Course getCourseByCourseName(String courseName) {
//        Course course = courseRepository.getCourseByName(courseName);
//        Integer courseId = course.getId();
//        course = courseRepository.getCourseById(courseId);
//        return course;
//    }

    public List<Course> getCoursesByName(String courseName) {
        List<Course> course = courseRepository.getCourseByName(courseName);
        return course;
    }
    public List<Course> getAllActiveCourse() {
        return courseRepository.getAllActiveCourse();
    }

    public List<Course> getAllNotActiveCourse() {
        return courseRepository.getAllNotActiveCourse();
    }



    public Course getLatestRow() {
        Course course = courseRepository.getLatestRow();
        return course;
    }
    public void deleteAllCourses() {
        courseRepository.deleteAllCourses();
    }
    public void deleteCourseById(Integer courseId) {
        Course course = courseRepository.getCourseById(courseId);
        course.setIsActive(false);
        courseRepository.save(course);
    }
    public void deleteAllCoursesCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date usableDate = dateFormatter.parse(createdDate);
        List<Course> course = courseRepository.deleteAllCoursesCreatedAfterDate(usableDate);
        course.stream().forEach(x -> x.setIsActive(false));
        courseRepository.saveAll(course);
    }
    public List<Course> getAllActiveCoursesForAStudent(Integer studentId) {
        List<Course> allActiveCoursesForAStudent = courseRepository.getAllActiveCoursesForAStudent(studentId);
        return allActiveCoursesForAStudent;
    }
    public List<Course> getCoursesByStudentId(Integer studentId) {
        List<Course> coursesOfAStudent = courseRepository.getCoursesByStudentId(studentId);
        return coursesOfAStudent;
    }

    public Course getLatestUpdatedDate() {
        Course course = courseRepository.getLatestUpdatedDate();
        return course;
    }

    public void deleteCoursesByName(String courseName) {

    List<Course>course =courseRepository.getCourseByName(courseName);
        course.stream().forEach(x -> x.setIsActive(false));
        courseRepository.saveAll(course);
    }
    public void deleteCoursesByCreatedDate(String createdDate) {
        List<Course> course = courseRepository.getCourseByCreatedDate(createdDate);
        course.stream().forEach(x -> x.setIsActive(false));
        courseRepository.saveAll(course);
    }

        public List<Course> getCoursesByCreatedDate(String createdDate) {
            List<Course> course = courseRepository.getCourseByCreatedDate(createdDate);
            return course;
        }
    public List<Course> getCoursesByUpdatedDate(String updatedDate) {
        List<Course> course = courseRepository.getCourseByUpdatedDate(updatedDate);
        return course;
    }
    public void deleteCoursesByUpdatedDate(String updatedDate) {
        List<Course> course = courseRepository.getCourseByUpdatedDate(updatedDate);
        course.stream().forEach(x -> x.setIsActive(false));
        courseRepository.saveAll(course);
    }
    public List<Course> getCoursesCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date usableDate = dateFormatter.parse(createdDate);
        List<Course> courses = courseRepository.getCourseCreatedAfterDate(usableDate);
        return courses;
    }

}













