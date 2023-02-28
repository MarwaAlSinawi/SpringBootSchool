package com.codeline.API.School.First.FirstSchoolAPIProject.RequestObject;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data

public class SchoolRequestForCreateDateUpdate {

    String date;
    Integer id;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
