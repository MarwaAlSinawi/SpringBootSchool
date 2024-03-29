package com.codeline.API.School.First.FirstSchoolAPIProject.Controlles;


import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Mark;
import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Student;
import com.codeline.API.School.First.FirstSchoolAPIProject.Services.ReportService;
import com.codeline.API.School.First.FirstSchoolAPIProject.Services.StudentService;
import com.codeline.API.School.First.FirstSchoolAPIProject.Slack.SlackClient;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "student")
// Any request coming form browser that is related to school it will be mapped with this class
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ReportService reportService;


    @Autowired
    SlackClient slackClient;
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    //function that returns all student
    public List<Student> getAllStudent() {
        List<Student> students = studentService.getAllStudent();
        return students;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer studentId) {
        Student student = studentService.getStudentById(studentId);
        return student;
    }

    @RequestMapping(value = "/getByStudentName", method = RequestMethod.GET)
    public Student getStudentByName(@RequestParam String student_name) {  //The student_name is the same variable as the sql
        Student studentName = studentService.getStudentByName(student_name);
        return studentName;
    }

    @RequestMapping(value = "/getAllstudentByIsActive")
    public List<Student> getAllActivestudent() {
        List<Student> activestudentList = studentService.getAllActiveStudent();
        return activestudentList;
    }


    @RequestMapping(value = "/getAllStudentByIsNotActive")
    public List<Student> getAllUnActiveStudent() {
        List<Student> notActiveStudentList = studentService.getAllNotActiveStudent();
        return notActiveStudentList;

    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Student getLatestRow() {
        Student student = studentService.getLatestRow();
        return student;
    }

    @RequestMapping(value = "getLatestUpdatedDate", method = RequestMethod.GET)
    public Student getLatestUpdatedDate() {
        Student student = studentService.getLatestUpdatedDate();
        return student;
    }

    @RequestMapping(value = "getStudentCreatedAfterDate", method = RequestMethod.GET)
    public List<Student> getStudentCreatedAfterDate() {
        List<Student> studentList = new ArrayList<>();
        studentList = studentService.getStudentCreatedAfterDate();
        return studentList;
    }

    @RequestMapping(value = "getByName", method = RequestMethod.GET)
    public Student getStudentByStudentName(@RequestParam String studentName) {
        Student student = studentService.getStudentByName(studentName);

        return student;
    }

    @RequestMapping(value = "getStudentsByCreatedDate", method = RequestMethod.GET)
    public List<Student> getStudentsByCreatedDate(@RequestParam String createdDate) {
        List<Student> student = studentService.getStudentsByCreatedDate(createdDate);
        return student;


    }
    @RequestMapping(value = "getStudentsByUpdatedDate", method = RequestMethod.GET)
    public List<Student> getStudentsByUpdatedDate(@RequestParam String updatedDate) {
        List<Student> student = studentService.getStudentsByUpdatedDate(updatedDate);
        return student;

    }
//    @RequestMapping(value = "deleteStudentById", method = RequestMethod.POST)
//    public void deleteStudentById(@RequestParam Integer studentId) {
//        studentService.deleteStudentById(studentId);
//
//    }

//    @RequestMapping(value = "studentReport" ,method = RequestMethod.GET)
//    public String  generateReport() throws JRException, FileNotFoundException {
//        return reportService.generateReportForStudent();
//    }
}


