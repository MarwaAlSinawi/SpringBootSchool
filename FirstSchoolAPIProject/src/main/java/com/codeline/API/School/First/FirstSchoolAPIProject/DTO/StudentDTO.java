package com.codeline.API.School.First.FirstSchoolAPIProject.DTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
public class StudentDTO {
        public StudentDTO(String schoolName, String studentName, String studentRollNumber) {
            this.schoolName = schoolName;
            this.studentName = studentName;
            this.studentRollNumber = studentRollNumber;
        }
        String schoolName;
        String studentName;
        String studentRollNumber;


    }
