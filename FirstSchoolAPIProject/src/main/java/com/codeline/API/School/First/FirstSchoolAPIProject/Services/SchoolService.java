package com.codeline.API.School.First.FirstSchoolAPIProject.Services;

import com.codeline.API.School.First.FirstSchoolAPIProject.Models.School;
import com.codeline.API.School.First.FirstSchoolAPIProject.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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




    public void deleteById(Integer id) {
    School deleteSchoolId = schoolRepository.getSchoolById(id);
    schoolRepository.delete(deleteSchoolId);
    }


    public void deleteBySchoolName(String name ) {

        School school= schoolRepository.getSchoolByName(name);
        school.setIsActive(Boolean.FALSE);
        schoolRepository.save(school);
    }


    public void deleteAll() {
     schoolRepository.deleteAll();
    }

    public void createSchool(String name){
        School school=new School();
        school.setName(name);
        school.setCreatedDate(new Date());
        school.setUpdatedDate(new Date());
        school.setIsActive(Boolean.TRUE);
        schoolRepository.save(school);
    }
    public void updateSchool(Integer id , String name, Boolean isActive){
        School school=schoolRepository.getSchoolById(id);
        school.setName(name);
        school.setCreatedDate(new Date());
        school.setUpdatedDate(new Date());
        school.setIsActive(isActive);
        schoolRepository.save(school);
    }


    public void setCreatedDateByUserInput(String date, Integer id) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        School school = schoolRepository.getSchoolById(id);
        school.setCreatedDate(convertedDateFromStringToDateFormat);
        schoolRepository.save(school);
    }

    public List<School> getSchoolCreatedAfterDate( String createdDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(createdDate);
     List<School> school=schoolRepository.getSchoolCreatedAfterDate(convertedDateFromStringToDateFormat);
        return school;
    }
    public  List<School> getSchoolsByCreatedDate(String createdDate){
        List<School> schools=schoolRepository.getSchoolsByCreatedDate(createdDate);
        return schools;
    }
    public List<School> getSchoolsByUpdatedDate(String updatedDate) {
        List<School> schools = schoolRepository.getSchoolsByUpdatedDate(updatedDate);
        return schools;
    }

}

