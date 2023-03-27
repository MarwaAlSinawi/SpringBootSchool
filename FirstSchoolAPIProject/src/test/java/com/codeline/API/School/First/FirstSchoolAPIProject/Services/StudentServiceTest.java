package com.codeline.API.School.First.FirstSchoolAPIProject.Services;

import com.codeline.API.School.First.FirstSchoolAPIProject.Controlles.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentServiceTest {
@Autowired
    StudentController studentController;
    @Test
    void getStudentById() {

            String Student =studentController.getStudentById(1).getName();
            assertEquals("fatma",Student);
        }
    @Test
    void getStudentById1() {

        String Student =studentController.getStudentById(2).getName();
        assertEquals("fatma",Student);
    }
    @Test
    void getStudentById2() {

        String Student =studentController.getStudentById(3).getName();
        assertEquals("marwa",Student);
    }
    @Test
    void getStudentById3() {

        String Student =studentController.getStudentById(4).getName();
        assertEquals("jannat",Student);
    }
    }
