package com.JavaProject.Service;
//importing all neccessary packages

import java.util.List;
import java.util.Optional;

import com.JavaProject.Entity.Student;

public interface StudentService {
	//defining all the CRUD and findByMethods of the Employee entity class

    Student getStudent(Long id);
    List<Student> getAllStudents();
    String insertStudent(Student student);
    String updateStudent(Student student);
    String deleteStudent(Long studentId);
    Optional<Student> getStudentByFirstName(String firstName);
    Optional<Student> getStudentByLastName(String lastName);
    Optional<Student> getStudentByEmail(String email);
}