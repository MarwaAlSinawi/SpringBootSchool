package com.codeline.API.School.First.FirstSchoolAPIProject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class TopPerformingCourseDTO {
    String schoolName;
    String courseName;
}
