package com.codeline.API.School.First.FirstSchoolAPIProject.Controlles;

import com.codeline.API.School.First.FirstSchoolAPIProject.Models.School;
import com.codeline.API.School.First.FirstSchoolAPIProject.RequestObject.SchoolRequestForCreateDateUpdate;
import com.codeline.API.School.First.FirstSchoolAPIProject.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
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
}

