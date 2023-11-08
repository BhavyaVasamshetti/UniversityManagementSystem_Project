//CourseRepo interface
package com.JavaProject.EntityRepo;
//importing neccessary packages

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JavaProject.Entity.Course;
//creating a repo interface which extends JpaRepository

public interface CourseRepo extends JpaRepository<Course, Long> {
	// defining the findByMethods with the attribute names of the entity class
	Optional<Course> findByCourseName(String courseName);

	Optional<Course> findByCourseCode(String courseCode);

	Optional<Course> findByCourseFees(int courseFees);

}
