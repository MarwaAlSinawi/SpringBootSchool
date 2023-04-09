package com.codeline.API.School.First.FirstSchoolAPIProject.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MarkDTO {
    public MarkDTO(String curseName, Integer obtainMark, String studentGrade) {
        this.curseName = curseName;
        this.obtainMark = obtainMark;
        this.studentGrade = studentGrade;
    }

    String curseName;
    Integer obtainMark;
    String  studentGrade;
}
