package com.JavaProject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//importing the neccessary packages
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;

    @ManyToOne
    @JoinColumn(name = "courseId")
    @JsonIgnoreProperties("students")
    private Course course;
}

