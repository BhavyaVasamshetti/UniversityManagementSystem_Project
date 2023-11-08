package com.JavaProject.Service;
//importing all neccessary packages

import java.util.List;

import com.JavaProject.Entity.Enrollment;


public interface EnrollmentService {
	// defining all the CRUD and findByMethods of the Project entity class
     Enrollment getEnrollment(Long id);
    
     List<Enrollment> getAllEnrollments();

     String insertEnrollment(Enrollment enrollment);
    
     String deleteEnrollment(Long enrollmentId);
 

    
}
