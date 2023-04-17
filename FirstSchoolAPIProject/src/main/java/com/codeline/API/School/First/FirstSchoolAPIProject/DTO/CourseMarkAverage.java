package com.codeline.API.School.First.FirstSchoolAPIProject.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CourseMarkAverage {
    String courseName;
    Double averageMark;

    //Constructor is similar to a class, it creates the instance of the class.
    //  its name is the same as the class name, and it has no return type.
    public CourseMarkAverage (String courseName, Double averageMark) {
        this.courseName = courseName;
        this.averageMark = averageMark;
    }
}
