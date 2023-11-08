package com.JavaProject.Entity;

//importing the neccessary packages
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Enrollment {
	// defining the attributes
	@Id
	private Long enrollmentId;
	private Date enrollmentDate;
	private int studentId;
	private int courseId;

	// Default constructor
	public Enrollment() {
		super();
	}

	// Parameterized constructor to initialize the attributes
	public Enrollment(Long enrollmentId, Date enrollmentDate, int studentId, int courseId) {
		super();
		this.enrollmentId = enrollmentId;
		this.enrollmentDate = enrollmentDate;
		this.studentId = studentId;
		this.courseId = courseId;
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

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "Enrollment [enrollmentId=" + enrollmentId + ", enrollmentDate=" + enrollmentDate + ", studentId="
				+ studentId + ", courseId=" + courseId + "]";
	}
}
