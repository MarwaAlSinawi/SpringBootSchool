package com.codeline.API.School.First.FirstSchoolAPIProject.Controlles;


import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Student;
import com.codeline.API.School.First.FirstSchoolAPIProject.Services.CourseService;
import com.codeline.API.School.First.FirstSchoolAPIProject.Services.MarkService;
import com.codeline.API.School.First.FirstSchoolAPIProject.Services.SchoolService;
import com.codeline.API.School.First.FirstSchoolAPIProject.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @Autowired // create instance, and then it can be used in all the program
    StudentService studentService;

    @Autowired // create instance, and then it can be used in all the program
    SchoolService schoolService;

    @Autowired // create instance, and then it can be used in all the program
    CourseService courseServices;

    @Autowired // create instance, and then it can be used in all the program
    MarkService markServices;

    @GetMapping
    public void addStudent() {
        studentService.addStudent();
    }

    @RequestMapping(value = "student/getStudentsBySchoolName", method = RequestMethod.GET)
    public List<Student> getStudentsBySchoolName(@RequestParam String schoolName) {
        return studentService.getStudentsBySchoolName(schoolName);
    }


}


