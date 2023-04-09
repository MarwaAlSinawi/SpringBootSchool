package com.codeline.API.School.First.FirstSchoolAPIProject.Controlles;

import com.codeline.API.School.First.FirstSchoolAPIProject.Report.StudentReportService;
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
        @RequestMapping(value = "schoolReport" ,method = RequestMethod.GET)
        public String generateSchoolsReport() throws JRException, FileNotFoundException {
            return reportService.generateReport();
        }

//        @RequestMapping(value = "studentReport" ,method = RequestMethod.GET)
//        public void generateReport() throws JRException, FileNotFoundException {
//            studentReportService.generateReportForStudent();
//        }

    @RequestMapping(value = "studentReport" ,method = RequestMethod.GET)
    public String  generateReport() throws JRException, FileNotFoundException {
        return reportService.generateReportForStudent();
    }
    }
