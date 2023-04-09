package com.codeline.API.School.First.FirstSchoolAPIProject.Services;

import com.codeline.API.School.First.FirstSchoolAPIProject.DTO.StudentDTO;
import com.codeline.API.School.First.FirstSchoolAPIProject.Models.School;
import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Student;
import com.codeline.API.School.First.FirstSchoolAPIProject.Repositories.SchoolRepository;
import com.codeline.API.School.First.FirstSchoolAPIProject.Repositories.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentRepository studentRepository;

    public static final String pathToReports = "C:\\Users\\user019\\Downloads\\Reports";//class path
    public String generateReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.getAllSchools();

        File file = ResourceUtils.getFile("classpath:School_Report.jrxml");//file object
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());//jasper Depnancy
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList);//compiler the report  acoording to jasper report
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\schools.pdf");
        return "Report generated : " + pathToReports+"\\schools.pdf";
    }

    public String generateReportForStudent() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.getAllStudent();
        List<StudentDTO> StudentDTOList = new ArrayList<>();
        for (Student studentListVariable : studentList) {
            String schoolName = studentListVariable.getSchool().getName();
            String studentName = studentListVariable.getName();
            String studentRollNumber = studentListVariable.getRollNumber();

            StudentDTO studentDTO = new StudentDTO(schoolName, studentName, studentRollNumber);
            StudentDTOList.add(studentDTO);
        }


//        File file = new File("C:\\Users\\user019\\IdeaProjects\\FirstSchoolAPIProject\\FirstSchoolAPIProject\\src\\main\\resources\\StudentReport.jrxml");
        File file = ResourceUtils.getFile("classpath:StudentReport.jrxml");//file object
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(StudentDTOList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "TechM");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\schoolStudebReport.pdf");
        return "Report generated : " + pathToReports + "\\schoolStudebReport.pdf";
    }

}
