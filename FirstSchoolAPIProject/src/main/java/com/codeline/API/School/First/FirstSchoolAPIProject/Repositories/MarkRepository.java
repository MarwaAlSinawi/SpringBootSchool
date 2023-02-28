package com.codeline.API.School.First.FirstSchoolAPIProject.Repositories;

import com.codeline.API.School.First.FirstSchoolAPIProject.Models.Mark;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Collection of code that is going to be used for the Objects
// to speak to database and give data to service

public interface MarkRepository extends CrudRepository<Mark, Integer> {

    @Query("SELECT m from Mark m")

    List<Mark> getAllMarks();

    @Query("SELECT m from Mark m where m.id= :markId")
    // :id is coming from the user

    Mark getMarkById(@Param("markId") Integer id);
}
