package com.JavaProject.Controller;
//importing all neccessary packages and classes

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JavaProject.Entity.Enrollment;
import com.JavaProject.Service.EnrollmentService;
//Controller class(RestController)

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
	// Dependency injection of the enrollmentService

    @Autowired
    private EnrollmentService enrollmentService;
    // Add a new enrollment

    @PostMapping("/add")
    public ResponseEntity<String> insertEnrollment(@RequestBody Enrollment enrollment) {
        String response = enrollmentService.insertEnrollment(enrollment);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    // Delete an enrollment by enrollmentId

    @DeleteMapping("/delete/{enrollmentId}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable("enrollmentId") Long enrollmentId) {
        String response = enrollmentService.deleteEnrollment(enrollmentId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
