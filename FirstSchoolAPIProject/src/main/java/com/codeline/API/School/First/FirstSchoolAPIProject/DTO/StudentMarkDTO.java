package com.codeline.API.School.First.FirstSchoolAPIProject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class StudentMarkDTO {
    Integer studentId;
    String studentRollNumber;
    String studentName;
    Integer averageMark;
}
