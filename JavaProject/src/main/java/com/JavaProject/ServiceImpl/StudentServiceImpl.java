package com.JavaProject.ServiceImpl;
//Importing all the neccessary packages and classes

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaProject.Entity.Student;
import com.JavaProject.EntityRepo.StudentRepo;
import com.JavaProject.Service.StudentService;
//service class

@Service
public class StudentServiceImpl implements StudentService {
    // Dependency injection of StudentRepo interface

    @Autowired
    private StudentRepo studentRepo;
    // overriding all the methods in the EnrollmentService interface and giving
 	// implementation for the methods

    @Override
    public Student getStudent(Long studentId) {
        return studentRepo.findById(studentId).orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public String insertStudent(Student s) {
        studentRepo.save(s);
        return "One student record has been inserted";
    }

    @Override
    public String updateStudent(Student s) {
        studentRepo.save(s);
        return "One student record has been updated";
    }

    @Override
    public String deleteStudent(Long studentId) {
        studentRepo.deleteById(studentId);
        return "One student record has been deleted";
    }

    @Override
    public Optional<Student> getStudentByFirstName(String firstName) {
        return studentRepo.findByFirstName(firstName);
    }

    @Override
    public Optional<Student> getStudentByLastName(String lastName) {
        return studentRepo.findByLastName(lastName);
    }

    @Override
    public Optional<Student> getStudentByEmail(String email) {
        return studentRepo.findByEmail(email);
    }
}
