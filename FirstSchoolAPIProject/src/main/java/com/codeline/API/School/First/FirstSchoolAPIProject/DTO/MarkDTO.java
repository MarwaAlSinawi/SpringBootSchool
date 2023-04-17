package com.codeline.API.School.First.FirstSchoolAPIProject.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MarkDTO {
    public MarkDTO(String courseName, Integer obtainMark, String studentGrade) {
        this.courseName = courseName;
        this.obtainMark = obtainMark;
        this.studentGrade = studentGrade;
    }

    String courseName;
    Integer obtainMark;
    String  studentGrade;
}
