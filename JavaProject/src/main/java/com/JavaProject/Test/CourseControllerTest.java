package com.JavaProject.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.JavaProject.Controller.CourseController;
import com.JavaProject.Entity.Course;
import com.JavaProject.Service.CourseService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
class CourseControllerTest {
    private CourseController courseController;
    
    @Mock
    private CourseService courseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        courseController = new CourseController(courseService);
    }

    @Test
    void testGetAllCourses() {
        List<Course> courses = Arrays.asList(new Course(), new Course());
        Mockito.when(courseService.getAllCourses()).thenReturn(courses);

        ResponseEntity<List<Course>> response = courseController.getAllCourses();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(courses, response.getBody());
    }

    @Test
    void testInsertCourse() {
        Course course = new Course();
        Mockito.when(courseService.insertCourse(course)).thenReturn("Course added successfully");

        ResponseEntity<String> response = courseController.insertCourse(course);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Course added successfully", response.getBody());
    }

    @Test
    void testUpdateCourse() {
        Course course = new Course();
        Mockito.when(courseService.updateCourse(course)).thenReturn("Course updated successfully");

        ResponseEntity<String> response = courseController.updateCourse(course);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Course updated successfully", response.getBody());
    }

    @Test
    void testDeleteCourse() {
        Long courseId = 1L;
        Mockito.when(courseService.deleteCourse(courseId)).thenReturn("Course deleted successfully");

        ResponseEntity<String> response = courseController.deleteCourse(courseId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Course deleted successfully", response.getBody());
    }

    @Test
    void testGetCI() {
        Long courseId = 1L;
        Course course = new Course();
        Mockito.when(courseService.getCourse(courseId)).thenReturn(course);

        ResponseEntity<Course> response = courseController.getCI(courseId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(course, response.getBody());
    }

    @Test
    void testGetCN() {
        String courseName = "Btech";
        Optional<Course> course = Optional.of(new Course());
        Mockito.when(courseService.getCourseByCourseName(courseName)).thenReturn(course);

        ResponseEntity<Course> response = courseController.getCN(courseName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(course.get(), response.getBody());
    }

    @Test
    void testGetCC() {
        String courseCode = "CSE";
        Optional<Course> course = Optional.of(new Course());
        Mockito.when(courseService.getCourseByCourseCode(courseCode)).thenReturn(course);

        ResponseEntity<Course> response = courseController.getCC(courseCode);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(course.get(), response.getBody());
    }

    @Test
    void testGetCF() {
        int courseFees = 10000;
        Optional<Course> course = Optional.of(new Course());
        Mockito.when(courseService.getCourseByCourseFees(courseFees)).thenReturn(course);

        ResponseEntity<Course> response = courseController.getCF(courseFees);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(course.get(), response.getBody());
    }
}
