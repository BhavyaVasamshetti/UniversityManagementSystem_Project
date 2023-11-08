package com.JavaProject.Entity;

//importing the neccessary packages
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	private Long studentId;
	private String firstName;
	private String lastName;
	private String email;
	private int courseId;

	// Default constructor

	public Student() {
		super();
	}
	// Parameterized constructor to initialize the attributes

	public Student(Long studentId, String firstName, String lastName, String email, int courseId) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.courseId = courseId;
	}
	// Getter and Setter methods for each attribute

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "Student{" + "studentId=" + studentId + ", firstName='" + firstName + '\'' + ", lastName='" + lastName
				+ '\'' + ", email='" + email + '\'' + ", courseId=" + courseId + '}';
	}
}