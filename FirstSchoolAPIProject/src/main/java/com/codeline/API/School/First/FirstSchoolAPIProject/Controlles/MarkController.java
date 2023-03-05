package com.codeline.API.School.First.FirstSchoolAPIProject.Controlles;

import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Course;
import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Mark;
import com.codeline.API.School.First.FirstSchoolAPIProject.Services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "mark")
// Any request coming form browser that is related to school it will be mapped with this class
public class MarkController {

    @Autowired
    MarkService markServices; // markServices Reference

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    //function that returns all student
    public List<Mark> getAllMarks() { // This will take from the browser and then return in the browser
        List<Mark> mark = markServices.getAllMarks();
        return mark;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Mark getMarkById(@RequestParam Integer markId) {
        Mark mark = markServices.getMarkById(markId);
        return mark;
    }

    @RequestMapping(value = "/getAllMarkByIsActive")
    public List<Mark> getAllActiveMark() {
        List<Mark> activeMarkList = markServices.getAllActiveMark();
        return activeMarkList;
    }

    @RequestMapping(value = "/getAllMarkByIsNotActive")
    public List<Mark> getAllUnActiveMark() {
        List<Mark> notActiveMarkList = markServices.getAllNotActiveMark();
        return notActiveMarkList;

    }
}
