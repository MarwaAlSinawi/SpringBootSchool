package com.codeline.API.School.First.FirstSchoolAPIProject.Controlles;


import com.codeline.API.School.First.FirstSchoolAPIProject.Services.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
@RestController
@RequestMapping(value = "report")
public class ReportController {


    @Autowired
    ReportService reportService;

    //        @Autowired
//        StudentReportService studentReportService;
    @RequestMapping(value = "schoolReport", method = RequestMethod.GET)
    public String generateSchoolsReport() throws JRException, FileNotFoundException {
        return reportService.generateReport();
    }

//        @RequestMapping(value = "studentReport" ,method = RequestMethod.GET)
//        public void generateReport() throws JRException, FileNotFoundException {
//            studentReportService.generateReportForStudent();
//        }

    @RequestMapping(value = "studentReport", method = RequestMethod.GET)
    public String generateReport() throws JRException, FileNotFoundException {
        return reportService.generateReportForStudent();
    }

    @RequestMapping(value = "MarkReport", method = RequestMethod.GET)
    public String generateMarkReport() throws JRException, FileNotFoundException {
        return reportService.generateMarkReport();
    }

    @RequestMapping(value = "generateMarkReportAverage", method = RequestMethod.GET)
    public void generateMarkReportAverage() throws JRException, FileNotFoundException {
        reportService.generateMarkReportAverage();

    }
    @RequestMapping(method = RequestMethod.GET, value = "/topPreformingStudentInEachSchoolReport")
    public String generateTopPerformingStudentInEachSchoolReport() {
        try {
            return reportService.generateTopPerformingStudentInEachSchool();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Exception("Error").getMessage();
        }
    }
    @RequestMapping(value = "generateOverAllStudentPerformance")
    public String generateOverAllStudentPerformance() throws Exception {
        return reportService.generateOverAllStudentPerformance();
    }
    @RequestMapping(value = "generateTotalNumberOfStudentsInEachSchool")
    public String generateTotalNumberOfStudentsInEachSchool() throws Exception {
        return reportService.generateTotalNumberOfStudentsInEachSchool();
    }
//    @RequestMapping(value = "generateDistributionOfGradesReport")
//    public String generateDistributionOfGradesReport() throws Exception {
//        return reportService.generateTheDistributionOfGrades();
//    }
    @RequestMapping(value = "generateTopPerformanceCoursesInEachSchoolReport")
    public String generateTopPerformanceCoursesInEachSchool() throws Exception {
        return reportService.generateTopPerformanceCoursesInEachSchool();
    }
    @RequestMapping(value = "generateDistributionOfGradesReport")
    public String generateDistributionOfGradesReport()throws Exception{
        return reportService.generateTheDistributionOfGrades();
    }

}
