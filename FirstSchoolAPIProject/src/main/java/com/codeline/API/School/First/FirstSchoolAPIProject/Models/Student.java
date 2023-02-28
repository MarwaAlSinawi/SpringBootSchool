package com.codeline.API.School.First.FirstSchoolAPIProject.Models;

import javax.persistence.*;

@Entity   // This annotation "entity" tells spring boot that this class is going to be a table in sql

public class Student extends BaseEntity{

    @Id // Defining the Primary key
    // To make the primary key … just like "Identity/Auto Increment"
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "student_name")
    String name;
    String rollNumber;


    @ManyToOne // doing the relation to the school where many student go to 1 school
    @JoinColumn(name = "school_id", referencedColumnName = "id")// defining the foreign key which is ID

    School school;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;

    }
}


