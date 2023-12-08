package com.JavaProject.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//importing the neccessary packages
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Course {
    @Id
    private Long courseId;
    private String courseName;
    private String courseCode;
    private int courseFees;

    @OneToMany(mappedBy = "course")
    @JsonIgnoreProperties("course")

    private List<Student> students;
}
