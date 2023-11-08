package com.JavaProject.ServiceImpl;
//Importing all the neccessary packages and classes

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaProject.Entity.Enrollment;
import com.JavaProject.EntityRepo.EnrollmentRepo;
import com.JavaProject.Service.EnrollmentService;

//service class


@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    // Dependency injection of EnrollmentRepo interface

	@Autowired
	EnrollmentRepo enrollmentRepo;

	public EnrollmentServiceImpl(EnrollmentRepo enrollmentRepo) {
		super();
		this.enrollmentRepo = enrollmentRepo;
	}

	// overriding all the methods in the EnrollmentService interface and giving
	// implementation for the methods
	@Override
    public Enrollment getEnrollment(Long enrollmentId) {
		Optional<Enrollment> e = enrollmentRepo.findById(enrollmentId);
		Enrollment e1 = e.get();
		return e1;
	}

	@Override
	public List<Enrollment> getAllEnrollments() {
		List<Enrollment> list = enrollmentRepo.findAll();
		return list;
	}

	@Override
	public String insertEnrollment(Enrollment e) {
		enrollmentRepo.save(e);
		return "One enrollment Record has been inserted";
	}

	@Override
	public String deleteEnrollment(Long enrollmentId) {
		enrollmentRepo.deleteById(enrollmentId);
		return "one enrollment recored has been deleted";
	}


}
