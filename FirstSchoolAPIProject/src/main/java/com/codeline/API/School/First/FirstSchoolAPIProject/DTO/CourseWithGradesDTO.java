package com.codeline.API.School.First.FirstSchoolAPIProject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class CourseWithGradesDTO {
    String courseName;
    String grade;
    Integer countOfMarks;
}
