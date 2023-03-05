package com.codeline.API.School.First.FirstSchoolAPIProject.Services;


import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Mark;
import com.codeline.API.School.First.FirstSchoolAPIProject.Repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // this is where everything is going to be done related to the object such as function and many more
// To give controller whatever it needs
public class MarkService {

    @Autowired // create instance, and then it can be used in all the program
    MarkRepository markRepository;


    public List<Mark> getAllMarks() {
        return markRepository.getAllMarks();
    }

    public Mark getMarkById(Integer id) {
        Mark mark = markRepository.getMarkById(id);
        return mark;

    }
    public List<Mark> getAllActiveMark() {
        return markRepository.getAllActiveMark();
    }

    public List<Mark> getAllNotActiveMark() {
        return markRepository.getAllNotActiveMark();
    }
}
