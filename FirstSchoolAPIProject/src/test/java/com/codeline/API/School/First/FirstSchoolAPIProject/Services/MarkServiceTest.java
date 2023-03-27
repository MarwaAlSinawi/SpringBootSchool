package com.codeline.API.School.First.FirstSchoolAPIProject.Services;

import com.codeline.API.School.First.FirstSchoolAPIProject.Controlles.MarkController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MarkServiceTest {
    @Autowired
    MarkController markController;
    @Test
    void getAllMarks() {
    }

    @Test
    void getMarkById() {
        String Mark = markController.getMarkById(1).getGrade();
        assertEquals("A+",Mark);
    }
    void getMarkById1() {
        String Mark = markController.getMarkById(2).getGrade();
        assertEquals("A+",Mark);
    }
    void getMarkById2() {
        String Mark = markController.getMarkById(2).getGrade();
        assertEquals("B",Mark);
    }
    void getMarkById3() {
        String Mark = markController.getMarkById(2).getGrade();
        assertEquals("C+",Mark);
    }

    @Test
    void getAllActiveMark() {
    }

    @Test
    void getAllNotActiveMark() {
    }
}