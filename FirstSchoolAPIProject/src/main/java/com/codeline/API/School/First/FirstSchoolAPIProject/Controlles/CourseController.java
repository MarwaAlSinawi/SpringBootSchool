package com.codeline.API.School.First.FirstSchoolAPIProject.Controlles;

import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Course;
import com.codeline.API.School.First.FirstSchoolAPIProject.Repositories.CourseRepository;
import com.codeline.API.School.First.FirstSchoolAPIProject.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "course")

public class CourseController {

    @Autowired // create instance, and then it can be used in all the program


    CourseService courseServices;
    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    //function that returns all student
    public List<Course> getAllCourse() {
        CourseRepository courseService;
        List<Course> course = courseServices.getAllCourse();
        return course;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Course getCourseById(@RequestParam Integer courseId) {
        Course course = courseServices.getCourseById(courseId);
        return course;
    }


    @RequestMapping(value = "/getAllCourseByIsActive")
    public List<Course> getAllActiveCourse() {
        List<Course> activeCoursesList = courseServices.getAllActiveCourse();
        return activeCoursesList;
    }

    @RequestMapping(value = "/getAllCourseByIsNotActive")
    public List<Course> getAllUnActiveCourse() {
        List<Course> notActiveCourseList = courseServices.getAllNotActiveCourse();
        return notActiveCourseList;

    }
    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Course getLatestRow() {
        Course course = courseServices.getLatestRow();
        return course;
    }
    @RequestMapping(value = "deleteAll", method = RequestMethod.POST)
    public void deleteAllCourses() {
        courseServices.deleteAllCourses();
    }
    @RequestMapping(value = "deleteCourseById", method = RequestMethod.POST)
    public void deleteCourseById(@RequestParam Integer courseId) {
        courseServices.deleteCourseById(courseId);
    }
    @RequestMapping(value = "deleteAllCoursesCreatedAfterDate", method = RequestMethod.POST)
    public String deleteAllCoursesCreatedAfterDate(@RequestParam String createdDate)  {
        try {
            courseServices.deleteAllCoursesCreatedAfterDate(createdDate);
        } catch (ParseException e) {
            return "Failed";
        }
        return "Success";
    }
    @RequestMapping(value = "getAllActiveCoursesForAStudent", method = RequestMethod.GET)
    public List<Course> getAllActiveCoursesForAStudent(@RequestParam Integer studentId) {
        List<Course> AllActiveCoursesForAStudent = courseServices.getCoursesByStudentId(studentId);
        return AllActiveCoursesForAStudent;
    }
    @RequestMapping(value = "getCourseByStudentId", method = RequestMethod.GET)
    public List<Course> getCourseByStudentId(@RequestParam Integer studentId) {
        List<Course> coursesOfAStudent =courseServices.getCoursesByStudentId(studentId);

        return coursesOfAStudent;
    }
    @RequestMapping(value = "getLatestUpdatedDate", method = RequestMethod.GET)
    public Course getLatestUpdatedDate() {
        Course course = courseServices.getLatestUpdatedDate();

        return course;
    }
    @RequestMapping(value = "deleteCourseByName", method = RequestMethod.POST)
    public void deleteCourseByName(@RequestParam String courseName) {
    courseServices.deleteCoursesByName(courseName);

    }
    @RequestMapping(value = "getCourseByCreatedDate", method = RequestMethod.GET)
    public List<Course> getCourseByCreatedDate(@RequestParam String createdDate)  {
        List<Course> course = courseServices.getCoursesByCreatedDate(createdDate);

        return course;

    }
    @RequestMapping(value = "getCourseByUpdatedDate", method = RequestMethod.GET)
    public List<Course> getCourseByUpdatedDate(@RequestParam String updatedDate)  {
        List<Course> course = courseServices.getCoursesByUpdatedDate(updatedDate);

        return course;

    }
//    @RequestMapping(value = "deleteCoursesByUpdatedDate", method = RequestMethod.POST)
//    public void deleteCoursesByUpdatedDate(@RequestParam String updatedDate){
//        courseServices.deleteCoursesByUpdatedDate(updatedDate);
//
//    }
    @RequestMapping(value = "updateCourse",method = RequestMethod.POST)
    public void updateCourse(@RequestParam Integer courseId,String courseName,Integer studentId,Boolean isActive){
       courseServices .updateCourse(courseId,courseName,studentId,isActive);
    }
    @RequestMapping(value = "createCourse", method = RequestMethod.POST)
    public void createCourse(@RequestParam String courseName, Integer studentId) {
        courseServices.createCourse(courseName, studentId);
    }


}




