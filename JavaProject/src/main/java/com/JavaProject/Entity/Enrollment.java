package com.JavaProject.Entity;

//importing the neccessary packages
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Enrollment {
    @Id
    private Long enrollmentId;
    private Date enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "studentId") // This assumes "studentId" is the foreign key column in the Enrollment table
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseId") // This assumes "courseId" is the foreign key column in the Enrollment table
    private Course course;

    // Default constructor
    public Enrollment() {
        super();
    }

    // Parameterized constructor to initialize the attributes
    public Enrollment(Long enrollmentId, Date enrollmentDate, Student student, Course course) {
        super();
        this.enrollmentId = enrollmentId;
        this.enrollmentDate = enrollmentDate;
        this.student = student;
        this.course = course;
    }

    // Getter and Setter methods for each attribute
    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Enrollment [enrollmentId=" + enrollmentId + ", enrollmentDate=" + enrollmentDate + ", student=" +
                student + ", course=" + course + "]";
    }
}
