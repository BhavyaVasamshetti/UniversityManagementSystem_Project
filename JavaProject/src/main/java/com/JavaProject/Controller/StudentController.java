package com.JavaProject.Controller;
////importing all neccessary packages and classes

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JavaProject.Entity.Student;
import com.JavaProject.Service.StudentService;
//Controller class (RestController) 

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    // Get all students

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    // Add a new student

    @PostMapping("/add")
    public ResponseEntity<String> insertStudent(@RequestBody Student student) {
        String response = studentService.insertStudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    // Update an existing student

    @PutMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
        String response = studentService.updateStudent(student);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // Delete a student by studentId

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentId") Long studentId) {
        String response = studentService.deleteStudent(studentId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // Get a student by studentId

    @GetMapping("/get/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable("studentId") Long studentId) {
        Student student = studentService.getStudent(studentId);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Get a student by first name

    @GetMapping("/byFirstName/{firstName}")
    public ResponseEntity<Student> getStudentByFirstName(@PathVariable("firstName") String firstName) {
        Optional<Student> student = studentService.getStudentByFirstName(firstName);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Get a student by last name

    @GetMapping("/byLastName/{lastName}")
    public ResponseEntity<Student> getStudentByLastName(@PathVariable("lastName") String lastName) {
        Optional<Student> student = studentService.getStudentByLastName(lastName);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Get a student by email

    @GetMapping("/byEmail/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable("email") String email) {
        Optional<Student> student = studentService.getStudentByEmail(email);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}