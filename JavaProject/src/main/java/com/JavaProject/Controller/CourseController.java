package com.JavaProject.Controller;
//importing all neccessary packages and classes

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

import com.JavaProject.Entity.Course;
import com.JavaProject.Service.CourseService;

//Controller class(RestController)

@RestController
@RequestMapping("/courses")
public class CourseController {
	// Dependency injection of the CourseService

    @Autowired
    private CourseService courseService;
    // Get all courses

	@GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
    // Add a new course

    @PostMapping("/add")
    public ResponseEntity<String> insertCourse(@RequestBody Course course) {
        String response = courseService.insertCourse(course);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    // Update an existing course

    @PutMapping("/update")
    public ResponseEntity<String> updateCourse(@RequestBody Course course) {
        String response = courseService.updateCourse(course);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // Delete a course by courseId

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable("courseId") Long courseId) {
        String response = courseService.deleteCourse(courseId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // Get a course by courseId

    @GetMapping("/get/{courseId}")
    public ResponseEntity<Course> getCI(@PathVariable("courseId") Long courseId) {
        Course course = courseService.getCourse(courseId);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Get a course by courseName

    @GetMapping("/bycourseName/{courseName}")
    public ResponseEntity<Course> getCN(@PathVariable("courseName") String courseName) {
        Optional<Course> course = courseService.getCourseByCourseName(courseName);
        if (course != null) {
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Get a course by courseCode

    @GetMapping("/byCourseCode/{courseCode}")
    public ResponseEntity<Course> getCC(@PathVariable("courseCode") String courseCode) {
        Optional<Course> course = courseService.getCourseByCourseCode(courseCode);
        if (course != null) {
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Get a course by courseFees

    @GetMapping("/byCourseFees/{courseFees}")
    public ResponseEntity<Course> getCF(@PathVariable("courseFees") int courseFees) {
        Optional<Course> course = courseService.getCourseByCourseFees(courseFees);
        if (course != null) {
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        

}
}
