package com.codeline.API.School.First.FirstSchoolAPIProject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@AllArgsConstructor
@Setter
public class CountOfStudentWithSchoolDTO {
    String schoolName;
    Integer countOfStudents;
}
