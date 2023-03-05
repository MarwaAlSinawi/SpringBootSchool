package com.codeline.API.School.First.FirstSchoolAPIProject.Services;

import com.codeline.API.School.First.FirstSchoolAPIProject.Models.School;
import com.codeline.API.School.First.FirstSchoolAPIProject.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service // this is where everything is going to be done related to the object such as function and many more
// To give controller whatever it needs
public class SchoolService {

    @Autowired // create instance, and then it can be used in all the program
    SchoolRepository schoolRepository;

    public List<School> getAllSchools() {
        return schoolRepository.getAllSchools();
    }

    public School getSchoolById(Integer id) {
        School school = schoolRepository.getSchoolById(id);
        return school;
    }

    public School getSchoolByName(String school_name) {
        School schoolName = schoolRepository.getSchoolByName(school_name);
        return schoolName;
    }

    public List<School> getAllActiveSchools() {
        return schoolRepository.getAllActiveSchools();
    }

    public List<School> getAllNotActiveSchools() {
        return schoolRepository.getAllNotActiveSchools();
    }

    public List<School> getLatestRow() {
        return schoolRepository.getLatestRow();
    }


    public List<School> getLatestUpdated() {
        return schoolRepository.getLatestUpdated();
    }


    public void setCreatedDateByUserInput(String date, Integer id) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        School school = schoolRepository.getSchoolById(id);
        school.setCreatedDate(convertedDateFromStringToDateFormat);
        schoolRepository.save(school);
    }
}
