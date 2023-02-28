package com.codeline.API.School.First.FirstSchoolAPIProject.Models;


import javax.persistence.*;

@Entity
public class Course  extends BaseEntity{

    @Id
    // Defining the Primary key
    // To make the primary key … just like "Identity/Auto Increment"
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "course_name")
    String name;

    @ManyToOne // many courses to one student
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    Student student;


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


}

