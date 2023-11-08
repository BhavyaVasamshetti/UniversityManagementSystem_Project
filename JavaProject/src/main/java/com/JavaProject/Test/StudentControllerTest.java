package com.JavaProject.Test;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.JavaProject.Controller.StudentController;
import com.JavaProject.Entity.Student;
import com.JavaProject.Service.StudentService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentControllerTest {
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        studentController = new StudentController(studentService);
    }

    @Test
    void testGetAllStudents() {
        List<Student> students = Arrays.asList(new Student(), new Student());
        Mockito.when(studentService.getAllStudents()).thenReturn(students);

        ResponseEntity<List<Student> responseEntity = studentController.getAllStudents();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(students, responseEntity.getBody());
    }

    @Test
    void testInsertStudent() {
        Student student = new Student();
        Mockito.when(studentService.insertStudent(student)).thenReturn("Student added successfully");

        ResponseEntity<String> responseEntity = studentController.insert(student);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Student added successfully", responseEntity.getBody());
    }

    @Test
    void testUpdateStudent() {
        Student student = new Student();
        Mockito.when(studentService.updateStudent(student)).thenReturn("Student updated successfully");

        ResponseEntity<String> responseEntity = studentController.update(student);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Student updated successfully", responseEntity.getBody());
    }

    @Test
    void testDeleteStudent() {
        Long studentId = 1L;
        Mockito.when(studentService.deleteStudent(studentId)).thenReturn("Student deleted successfully");

        ResponseEntity<String> responseEntity = studentController.delete(studentId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Student deleted successfully", responseEntity.getBody());
    }

    @Test
    void testGetStudent() {
        Long studentId = 101;
        Student student = new Student();
        Mockito.when(studentService.getStudent(studentId)).thenReturn(student);

        ResponseEntity<Student> responseEntity = studentController.get(studentId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(student, responseEntity.getBody());
    }

    @Test
    void testGetStudentByFirstName() {
        String firstName = "Bhavya";
        Optional<Student> student = Optional.of(new Student());
        Mockito.when(studentService.getStudentByFirstName(firstName)).thenReturn(student);

        ResponseEntity<Student> responseEntity = studentController.getFN(firstName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(student.get(), responseEntity.getBody());
    }

    @Test
    void testGetStudentByLastName() {
        String lastName = "Vasamshetti";
        Optional<Student> student = Optional.of(new Student());
        Mockito.when(studentService.getStudentByLastName(lastName)).thenReturn(student);

        ResponseEntity<Student> responseEntity = studentController.getLN(lastName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(student.get(), responseEntity.getBody());
    }

    @Test
    void testGetStudentByEmail() {
        String email = "bhavyabharathi@example.com";
        Optional<Student> student = Optional.of(new Student());
        Mockito.when(studentService.getStudentByEmail(email)).thenReturn(student);

        ResponseEntity<Student> responseEntity = studentController.getEmail(email);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(student.get(), responseEntity.getBody());
    }
}
