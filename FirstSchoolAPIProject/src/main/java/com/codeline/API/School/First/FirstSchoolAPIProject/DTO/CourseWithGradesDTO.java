package com.codeline.API.School.First.FirstSchoolAPIProject.DTO;

import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class CourseWithGradesDTO {
    Course courseName;
    String grade;
    Integer countOfMarks;
}
