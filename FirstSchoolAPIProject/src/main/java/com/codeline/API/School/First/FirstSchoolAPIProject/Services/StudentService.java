package com.codeline.API.School.First.FirstSchoolAPIProject.Services;


import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Course;
import com.codeline.API.School.First.FirstSchoolAPIProject.Models.School;
import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Student;
import com.codeline.API.School.First.FirstSchoolAPIProject.Repositories.SchoolRepository;
import com.codeline.API.School.First.FirstSchoolAPIProject.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // this is where everything is going to be done related to the object such as function and many more
// To give controller whatever it needs
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    public void addStudent() {
        Student student = new Student();
        student.setName("Marwa");
        student.setRollNumber("2");
        studentRepository.save(student);
    }

    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    public void deleteStudentById(Integer Id) {
        Student StudentToDelete = studentRepository.findById(Id).get();
        studentRepository.delete(StudentToDelete);
    }

    public Student getStudentById(Integer id) {
        Student student = studentRepository.getStudentById(id);
        return student;
    }

    public Student getStudentByName(String student_name) {
        Student studentName = studentRepository.getStudentByName(student_name);
        return studentName;
    }

    public List<Student> getStudentsBySchoolName(String schoolName) {
        School school = schoolRepository.getSchoolByName(schoolName);
        Integer schoolId = school.getId();
        List<Student> studentList = studentRepository.getStudentsBySchoolId(schoolId);
        return studentList;
    }
    public List<Student> getAllActiveStudent() {
        return studentRepository.getAllActiveStudent();
    }

    public List<Student> getAllNotActiveStudent() {
        return studentRepository.getAllNotActiveStudent();
    }



    public Student getLatestRow() {
        Student student = studentRepository.getLatestRow();
        return student;
    }
}
