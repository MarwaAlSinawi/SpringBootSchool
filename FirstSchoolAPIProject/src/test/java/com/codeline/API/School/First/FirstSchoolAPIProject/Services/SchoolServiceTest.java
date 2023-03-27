package com.codeline.API.School.First.FirstSchoolAPIProject.Services;

import com.codeline.API.School.First.FirstSchoolAPIProject.Controlles.SchoolController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SchoolServiceTest {
@Autowired
SchoolController schoolController;
    @Test
    void getSchoolById() {
        String School = schoolController.getSchoolById(1).getName();
        assertEquals("hgt",School);
    }
    @Test
    void getSchoolById1() {
        String School = schoolController.getSchoolById(2).getName();
        assertEquals("hgt",School);
    }
    @Test
    void getSchoolById2() {
        String School = schoolController.getSchoolById(3).getName();
        assertEquals("abcd",School);
    }
}