package com.codeline.API.School.First.FirstSchoolAPIProject.Schedules;

import com.codeline.API.School.First.FirstSchoolAPIProject.Models.School;
import com.codeline.API.School.First.FirstSchoolAPIProject.Services.CourseService;
import com.codeline.API.School.First.FirstSchoolAPIProject.Services.MarkService;
import com.codeline.API.School.First.FirstSchoolAPIProject.Services.SchoolService;
import com.codeline.API.School.First.FirstSchoolAPIProject.Services.StudentService;
import com.codeline.API.School.First.FirstSchoolAPIProject.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class schedules {

    @Autowired
    SlackClient slackClient;

    @Autowired
    SchoolService schoolService;


    @Autowired
    StudentService studentService;

    @Autowired
    MarkService markServices;

    @Autowired
    CourseService courseServices;


    @Scheduled(cron = "* 15 * * * *")
    //function that returns all school
    public List<School> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        for(School school:schools){
        slackClient.sendMessage("the school ID is :"+school.getId());
        slackClient.sendMessage("the school name is :"+school.getName());


    }
        return schools;
    }}


