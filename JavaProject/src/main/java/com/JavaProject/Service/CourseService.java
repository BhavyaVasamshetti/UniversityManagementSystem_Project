package com.JavaProject.Service;
//importing all neccessary packages
import java.util.List;
import java.util.Optional;

import com.JavaProject.Entity.Course;


public interface CourseService {
	//defining all the CRUD and findByMethods of the Employee entity class
     Course getCourse(Long id);
    
     List<Course> getAllCourses();
    
     String insertCourse(Course course);
    
     String updateCourse(Course course);
    
     String deleteCourse(Long courseId);
    
     Optional<Course> getCourseByCourseName(String courseName);
    
     Optional<Course> getCourseByCourseCode(String courseCode);
     Optional<Course> getCourseByCourseFees(int courseFees);


    
}
