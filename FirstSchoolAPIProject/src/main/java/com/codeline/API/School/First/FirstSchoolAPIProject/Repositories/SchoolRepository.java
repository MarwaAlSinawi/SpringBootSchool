package com.codeline.API.School.First.FirstSchoolAPIProject.Repositories;

import com.codeline.API.School.First.FirstSchoolAPIProject.Models.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Collection of code that is going to be used for the Objects
// to speak to database and give data to service

public interface SchoolRepository extends CrudRepository<School, Integer> {
    @Query("SELECT sch from School sch")

    List<School> getAllSchools();

    @Query("SELECT sch from School sch where sch.id= :schoolId")
    // :id is coming from the user

    School getSchoolById(@Param("schoolId") Integer id);

    @Query("SELECT sch from School sch where sch.name= :schoolName")

    School getSchoolByName(@Param("schoolName") String school_name);

    @Query(value = "SELECT sch from School sch where sch.isActive = true")
    List<School> getAllActiveSchools();

    @Query(value = "SELECT sch from School sch where sch.isActive = false")
    List<School> getAllNotActiveSchools();

    @Query(value = "SELECT sch from School sch where sch.id = (SELECT Max(sch.id) from School sch)")
    List<School> getLatestRow();

    @Query(value = "SELECT sch from School sch where sch.UpdatedDate = (SELECT Max(sch.UpdatedDate) from School sch)")
    List<School> getLatestUpdated();

    @Query(value = "SELECT sch from School sch where sch.getSchoolCreatedAfterDate = (SELECT Max(sch.getSchoolCreatedAfterDate) from School sch)")
    List<School> getSchoolCreatedAfterDate();







}
