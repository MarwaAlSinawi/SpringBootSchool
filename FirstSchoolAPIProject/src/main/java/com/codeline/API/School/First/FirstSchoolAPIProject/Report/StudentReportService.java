package com.codeline.API.School.First.FirstSchoolAPIProject.Report;

import com.codeline.API.School.First.FirstSchoolAPIProject.DTO.StudentDTO;
import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Student;
import com.codeline.API.School.First.FirstSchoolAPIProject.Repositories.SchoolRepository;
import com.codeline.API.School.First.FirstSchoolAPIProject.Repositories.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class StudentReportService {
//    @Autowired
//    SchoolRepository schoolRepository;
//
//    @Autowired
//    StudentRepository studentRepository;
//    @Autowired
//    public static final String pathToReports = "C:\\Users\\user019\\Downloads\\Reports";

//    public String generateReportForStudent() throws FileNotFoundException, JRException {
//        List<Student> studentList = studentRepository.getAllStudent();
//        List<StudentDTO> StudentDTOList = new ArrayList<>();
//        for (Student studentListVariable : studentList) {
//            String schoolName = studentListVariable.getSchool().getName();
//            String studentName = studentListVariable.getName();
//            String studentRollNumber = studentListVariable.getRollNumber();
//
//            StudentDTO studentDTO = new StudentDTO(schoolName, studentName, studentRollNumber);
//            StudentDTOList.add(studentDTO);
//        }
//
//
//        File file = new File("C:\\Users\\user019\\IdeaProjects\\FirstSchoolAPIProject\\FirstSchoolAPIProject\\src\\main\\resources\\StudentReport.jrxml");
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(StudentDTOList);
//        Map<String, Object> paramters = new HashMap<>();
//        paramters.put("CreatedBy", "TechM");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
//        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\schoolStudebReport.pdf");
//        return "Report generated : " + pathToReports + "\\schoolStudebReport.pdf";
//    }
}

