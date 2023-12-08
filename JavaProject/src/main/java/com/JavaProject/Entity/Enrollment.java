package com.JavaProject.Entity;

//importing the neccessary packages
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class Enrollment {
    @Id
    private Long enrollmentId;
    private Date enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "studentId") // This assumes "studentId" is the foreign key column in the Enrollment table
    @JsonIgnoreProperties("enrollments")

    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseId") // This assumes "courseId" is the foreign key column in the Enrollment table
    @JsonIgnoreProperties("enrollments")

    private Course course;
}
