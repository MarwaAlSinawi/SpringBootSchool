package com.codeline.API.School.First.FirstSchoolAPIProject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class OverallSchoolStudentPerformanceDTO {
    String schoolName;
    Integer averageOfAllStudentsMarks;
}
