package com.codeline.API.School.First.FirstSchoolAPIProject.Report;

import com.codeline.API.School.First.FirstSchoolAPIProject.DTO.MarkDTO;
import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Mark;
import com.codeline.API.School.First.FirstSchoolAPIProject.Repositories.MarkRepository;
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
public class MarkReportSerives {
    @Autowired
    MarkRepository markRepository;




//    public String generateMarkReport() throws FileNotFoundException, JRException {
//        List<Mark> markList = markRepository.getAllMarks();
//        List<MarkDTO> MarkDTOList = new ArrayList<>();
//        for (Mark markListVariable : markList) {
//            String courseName = markListVariable.getCourse().getName();
//
//            Integer obtainMarks = markListVariable.getObtainMark();
//            String studentGrade = markListVariable.getGrade();
//            MarkDTO markDTO = new MarkDTO(courseName, obtainMarks, studentGrade);
//            MarkDTOList.add(markDTO);
//        }
//
//        File file = ResourceUtils.getFile("classpath:School_Report.jrxml");//file object
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(MarkDTOList);
//        Map<String, Object> paramters = new HashMap<>();
//        paramters.put("CreatedBy", "Shirin");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
//        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\MarkReport.pdf");
//        return "Report generated : " + pathToReports + "\\MarkReport.pdf";
//    }
}
