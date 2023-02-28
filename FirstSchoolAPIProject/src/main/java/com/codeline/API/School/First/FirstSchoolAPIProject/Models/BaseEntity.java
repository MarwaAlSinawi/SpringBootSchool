package com.codeline.API.School.First.FirstSchoolAPIProject.Models;

import jdk.jfr.Timestamp;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@Data
@MappedSuperclass
public class BaseEntity {
 @CreatedDate
 Date createdDate;

@Timestamp
Date UpdatedDate;
 Boolean isActive;

 public Date getCreatedDate() {
  return createdDate;
 }

 public void setCreatedDate(Date createdDate) {
  this.createdDate = createdDate;
 }

 public Date getUpdatedDate() {
  return UpdatedDate;
 }

 public void setUpdatedDate(Date updatedDate) {
  UpdatedDate = updatedDate;
 }

 public Boolean getActive() {
  return isActive;
 }

 public void setActive(Boolean active) {
  isActive = active;
 }
}
