package com.codeline.API.School.First.FirstSchoolAPIProject.Controlles;

import com.codeline.API.School.First.FirstSchoolAPIProject.Models.School;
import com.codeline.API.School.First.FirstSchoolAPIProject.RequestObject.SchoolRequestForCreateDateUpdate;
import com.codeline.API.School.First.FirstSchoolAPIProject.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "school")

public class SchoolController {

    @Autowired
    SchoolService schoolService;


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    //function that returns all school
    public List<School> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();

        return schools;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return school;
    }

    @RequestMapping(value = "/getBySchoolName", method = RequestMethod.GET)
    public School getBySchoolName(@RequestParam String school_name) {
        School schoolName = schoolService.getSchoolByName(school_name);
        return schoolName;
    }

    @RequestMapping(value = "/getAllSchoolByIsActive")
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
        return activeSchoolsList;
    }

    @RequestMapping(value = "/getAllSchoolByIsNotActive")
    public List<School> getAllUnActiveSchools() {
        List<School> notActiveSchoolList = schoolService.getAllNotActiveSchools();
        return notActiveSchoolList;

    }

    @RequestMapping(value = "updateCreatedDateByUserInput")
    public void setCreatedDateByUserInput(@RequestBody SchoolRequestForCreateDateUpdate data) throws ParseException {
        schoolService.setCreatedDateByUserInput(data.getDate(), data.getId());

    }

    @RequestMapping(value = "/getLatestRow")
    public List<School> getLatestRow() {
        List<School> getLatestRow = schoolService.getLatestRow();
        return getLatestRow;
    }

    @RequestMapping(value = "/getLatestUpdated")
    public List<School> getLatestUpdated() {
        List<School> getLatestUpdated = schoolService.getLatestUpdated();
        return getLatestUpdated;
    }

    @RequestMapping(value = "/deleteById")
    public void deleteById(Integer id) {
       schoolService.deleteById(id);

    }

    @RequestMapping(value = "/deleteAll")
    public void deleteAll() {
        schoolService.deleteAll();

    }

    @RequestMapping(value = "/deleteBySchoolName")
    public void deleteBySchoolName(@RequestParam String name) {
        schoolService.deleteBySchoolName(name);

    }

    @RequestMapping(value = "/createSchool")
    public void createSchool( String name) {
        schoolService.createSchool(name);

    }






    // @RequestMapping(value = "/getSchoolCreatedAfterDate", method = RequestMethod.GET)
   // public School getBySchoolName(@RequestParam String createdDate) {
       // School createdDateAfter = schoolService.getSchoolCreatedAfterDate(createdDate);
       // return createdDateAfter;
    }

