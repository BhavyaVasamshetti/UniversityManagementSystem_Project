package com.JavaProject.ServiceImpl;
//Importing all the neccessary packages and classes

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JavaProject.Entity.Course;
import com.JavaProject.EntityRepo.CourseRepo;
import com.JavaProject.Service.CourseService;

//service class

@Service
public class CourseServiceImpl implements CourseService {
    // Dependency injection of CourseRepo interface

	@Autowired
	CourseRepo courseRepo;

	public CourseServiceImpl(CourseRepo courseRepo) {
		super();
		this.courseRepo = courseRepo;
	}

	// overriding all the methods in the CourseService interface and giving
	// implementation for the methods
	@Override
	public Course getCourse(Long courseId) {
		Optional<Course> c = courseRepo.findById(courseId);
		Course c1 = c.get();
		return c1;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> list = courseRepo.findAll();
		return list;
	}

	@Override
	public String insertCourse(Course c) {
		courseRepo.save(c);
		return "One course Record has been inserted";
	}

	@Override
	public String updateCourse(Course c) {
		courseRepo.save(c);
		return "One course Record has been updated";
	}

	@Override
	public String deleteCourse(Long courseId) {
		courseRepo.deleteById(courseId);
		return "one course recored has been deleted";
	}


	@Override
	public Optional<Course> getCourseByCourseName(String courseName) {
		return courseRepo.findByCourseName(courseName);
	}

	@Override
	public Optional<Course> getCourseByCourseCode(String courseCode) {
        return courseRepo.findByCourseCode(courseCode);
	}
	@Override
	public Optional<Course> getCourseByCourseFees(int courseFees) {
        return courseRepo.findByCourseFees(courseFees);

   }
}
