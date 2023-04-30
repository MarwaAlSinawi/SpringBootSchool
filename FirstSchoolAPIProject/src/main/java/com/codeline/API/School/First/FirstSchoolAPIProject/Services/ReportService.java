package com.codeline.API.School.First.FirstSchoolAPIProject.Services;

import com.codeline.API.School.First.FirstSchoolAPIProject.DTO.*;
import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Course;
import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Mark;
import com.codeline.API.School.First.FirstSchoolAPIProject.Models.School;
import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Student;
import com.codeline.API.School.First.FirstSchoolAPIProject.Repositories.CourseRepository;
import com.codeline.API.School.First.FirstSchoolAPIProject.Repositories.MarkRepository;
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

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private CourseRepository courseRepository;

    public static final String pathToReports = "C:\\Users\\user019\\Downloads\\Reports";//class path

    public String generateReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.getAllSchools();

        File file = ResourceUtils.getFile("classpath:School_Report.jrxml");//file object
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());//jasper Depnancy
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList);//compiler the report  acoording to jasper report
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\schools.pdf");
        return "Report generated : " + pathToReports + "\\schools.pdf";
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

    public String generateMarkReport() throws FileNotFoundException, JRException {
        List<Mark> markList = markRepository.getAllMarks();
        List<MarkDTO> MarkDTOList = new ArrayList<>();
        for (Mark markListVariable : markList) {
            String courseName = markListVariable.getCourse().getName();

            Integer obtainMarks = markListVariable.getObtainMark();
            String studentGrade = markListVariable.getGrade();
            MarkDTO markDTO = new MarkDTO(courseName, obtainMarks, studentGrade);
            MarkDTOList.add(markDTO);
        }

        File file = ResourceUtils.getFile("classpath:StudentReport.jrxml");//file object
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(MarkDTOList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Marwa Alsinawi");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\MarkReport.pdf");
        return "Report generated : " + pathToReports + "\\MarkReport.pdf";
    }





        public String generateMarkReportAverage() throws FileNotFoundException, JRException {
            List<Mark> markList = markRepository.getAllMarks();

            List<CourseMarkAverage> CourseNameWithAverageMarkDTOList = new ArrayList<>(); // Creating new ArrayList to store the data that will be used to generate the report.
            Map<String, List<Integer>> courseObtainedMarksMap = new HashMap<>(); // Creating a new hashmap to store the obtained marks for each course. String for course name and integer for obtain marks
            for (Mark mark : markList) { // loop is used to iterate over each Mark object in the markList.
                String courseName = mark.getCourse().getName(); // table mark there is foreign key of course
                Integer obtainedMarks = mark.getObtainMark();
                if (courseObtainedMarksMap.containsKey(courseName)) { // this is used to check if the obtain mark is added to the list or not,\
                    // if not then a new list is created with the obtain mark and the course name is added with the hashmap.
                    courseObtainedMarksMap.get(courseName).add(obtainedMarks);
                } else {
                    List<Integer> obtainedMarksList = new ArrayList<>();
                    obtainedMarksList.add(obtainedMarks);
                    courseObtainedMarksMap.put(courseName, obtainedMarksList);
                }

            }
            // Loop through the courseObtainedMarksMap and calculate the averageMarks for each courseName
            for (String courseName : courseObtainedMarksMap.keySet()) {
                List<Integer> obtainedMarksList = courseObtainedMarksMap.get(courseName);
                Double sum = 0.0;
                for (Integer obtainedMark : obtainedMarksList) {
                    sum = sum + obtainedMark;
                }
                Double averageMark = sum / obtainedMarksList.size();

                CourseMarkAverage markDTOListObj = new CourseMarkAverage(courseName, averageMark);
                CourseNameWithAverageMarkDTOList.add(markDTOListObj);
            }
            File file = ResourceUtils.getFile("classpath:Report.jrxml");//file object
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(CourseNameWithAverageMarkDTOList);
            Map<String, Object> paramters = new HashMap<>();
            paramters.put("CreatedBy", "Marwa ");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\AverageMarkOfEachCourseQuestion3.pdf");

            return "Report generated : " + pathToReports + "\\AverageMarkOfEachCourseQuestion3.pdf";
        }
    public String generateTopPerformingStudentInEachSchool() throws Exception {
        List<School> schoolList = schoolRepository.getAllSchools();
        List<TopPerformingStudentDTO> topPreformingStudentDTOSList = new ArrayList<>();

        for (School school : schoolList) {
            List<Student> studentList = studentRepository.getStudentBySchoolId(school.getId());
            Integer highestMarks = 0;
            Student studentWithHighestMarks = new Student();
            for (Student student : studentList) {
                Integer studentId = student.getId();
                Integer studentTotalMark = markRepository.getSumOfMarksByStudentId(studentId);
                if (studentTotalMark != null && studentTotalMark > highestMarks) {
                    highestMarks = studentTotalMark;
                    studentWithHighestMarks = student;
                }
            }
            topPreformingStudentDTOSList.add(new TopPerformingStudentDTO(studentWithHighestMarks.getName(),school.getName()));

        }
        File file = ResourceUtils.getFile("classpath:topPreformingStudent.jrxml");//file object
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(topPreformingStudentDTOSList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Marwa ");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\TopPerformingStudent.pdf");

        return "Report generated : " + pathToReports + "\\topPreformingStudent.pdf";
    }
    public String generateOverAllStudentPerformance() throws Exception {
        List<Student> studentList = studentRepository.getAllStudent();
        List<StudentMarkDTO> studentMarkDTOS = new ArrayList<>();
        for (Student student : studentList) {
            Integer studentId = student.getId();
            String studentRollNumber = student.getRollNumber();
            String studentName = student.getName();
            Integer avgOfMarksByStudentId = markRepository.getAvgMarkByStudentId(studentId);
            StudentMarkDTO studentDto = new StudentMarkDTO(studentId, studentRollNumber, studentName, avgOfMarksByStudentId);
            studentMarkDTOS.add(studentDto);

        }
        File file = ResourceUtils.getFile("classpath:generateOverAllStudentPerformance.jrxml");//file object
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentMarkDTOS);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Marwa ");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\generateOverAllStudentPerformance.pdf");

        return "Report generated : " + pathToReports + "\\generateOverAllStudentPerformance.pdf";
    }
    public String generateTotalNumberOfStudentsInEachSchool() throws Exception {
        List<School> schoolList = schoolRepository.getAllSchools();
        List<CountOfStudentWithSchoolDTO> countOfStudent = new ArrayList<>();
        for (School school : schoolList) {
            Integer schoolId = school.getId();
            String schoolName = school.getName();
            Integer countOfStudents = studentRepository.getCountOfStudentsBySchoolId(schoolId);
            CountOfStudentWithSchoolDTO countOfStudentWithSchoolDTO = new CountOfStudentWithSchoolDTO(schoolName, countOfStudents);
            countOfStudent.add(countOfStudentWithSchoolDTO);
        }
        File file = ResourceUtils.getFile("classpath:generateTotalNumberOfStudentsInEachSchool.jrxml");//file object
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(countOfStudent);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Marwa ");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\generateTotalNumberOfStudentsInEachSchool.pdf");

        return "Report generated : " + pathToReports + "\\generateTotalNumberOfStudentsInEachSchool.pdf";
    }
    public String generateTheDistributionOfGrades() throws Exception {
        List<String> coursesNames = courseRepository.getAllCourseName();
        List<String> listOfUniqueGrades = markRepository.getDistinctGrades();
        List<CourseWithGradesDTO> courseWithGradesDTOS = new ArrayList<>();
        for (String courseName : coursesNames) {
            for (String grade : listOfUniqueGrades) {
                Integer countOfMarksByGradeAndCourseName = markRepository.getCountOfMarksByGradeAndCourseName(grade, courseName);
                courseWithGradesDTOS.add(new CourseWithGradesDTO(courseName, grade, countOfMarksByGradeAndCourseName));
            }
        }
        File file = ResourceUtils.getFile("classpath:generateTheDistributionOfGrades.jrxml");//file object
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseWithGradesDTOS);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Marwa ");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\generateTheDistributionOfGrades.pdf");

        return "Report generated : " + pathToReports + "\\generateTheDistributionOfGrades.pdf";
    }
    public String generateTopPerformanceCoursesInEachSchool() throws Exception {
        List<School> schoolList = schoolRepository.getAllSchools();
        Map<School, Course> schoolCourseMap = new HashMap<>();
        List<TopPerformingCourseDTO> topPerformingCourseDTOS = new ArrayList<>();
        for (School school : schoolList) {
            Integer schoolId = school.getId();
            List<Course> courseList = courseRepository.getCourseBySchoolId(schoolId);
            Integer highestAverageMarkForCourses = 0;
            Course courseWithHighestMark = new Course();
            for (Course course : courseList) {
                Integer courseId = course.getId();
                Integer averageMarkForCourse = markRepository.averageMarkForCourse(courseId);
                if (averageMarkForCourse != null && averageMarkForCourse > highestAverageMarkForCourses) {
                    highestAverageMarkForCourses = averageMarkForCourse;
                    courseWithHighestMark = course;
                }
                topPerformingCourseDTOS.add(new TopPerformingCourseDTO(school.getName(),courseWithHighestMark.getName()));
            }
        }
        File file = ResourceUtils.getFile("classpath:generateTopPerformanceCoursesInEachSchool.jrxml");//file object
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(topPerformingCourseDTOS);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Marwa ");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\generateTopPerformanceCoursesInEachSchool.pdf");

        return "Report generated : " + pathToReports + "\\generateTopPerformanceCoursesInEachSchool.pdf";
    }
    public String generateStudentWithHighCourseScoreAboveThresholdReport(Integer courseThreshold) throws Exception {
        List<Course> courseList = courseRepository.getAllCourse();
        List<CourseWithStudentCountDTO> courseWithStudentCountDTOS = new ArrayList<>();
        for (Course course : courseList) {
            String courseName = course.getName();
            Integer countOfStudents = markRepository.countOfStudentsHavingHighScoreInCourse(courseThreshold, courseName);
            courseWithStudentCountDTOS.add(new CourseWithStudentCountDTO(courseName, countOfStudents));
        }
        File file = ResourceUtils.getFile("classpath:generateStudentWithHighCourseScoreAboveThresholdReport.jrxml");//file object
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseWithStudentCountDTOS);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Marwa ");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\generateStudentWithHighCourseScoreAboveThresholdReport.pdf");

        return "Report generated : " + pathToReports + "\\generateStudentWithHighCourseScoreAboveThresholdReport.pdf";
    }
    public String generateOverallPerformanceOfEachSchool() throws Exception {
        List<School> schoolList = schoolRepository.getAllSchools();
        List<OverallSchoolStudentPerformanceDTO> overallSchoolStudentPerformanceDTOS = new ArrayList<>();
        for (School school : schoolList) {
            String schoolName = school.getName();
            Integer schoolId = school.getId();
            Integer averageOfAllStudentsMarks = markRepository.getAvgOfMarksBySchoolId(schoolId);
            overallSchoolStudentPerformanceDTOS.add(new OverallSchoolStudentPerformanceDTO(schoolName, averageOfAllStudentsMarks));
        }
        File file = ResourceUtils.getFile("classpath:generateOverallPerformanceOfEachSchool.jrxml");//file object
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(overallSchoolStudentPerformanceDTOS);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Marwa ");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\generateOverallPerformanceOfEachSchool.pdf");

        return "Report generated : " + pathToReports + "\\generateOverallPerformanceOfEachSchool.pdf";
    }


}




