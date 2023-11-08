package com.JavaProject.Test;


import com.JavaProject.Controller.EnrollmentController;
import com.JavaProject.Entity.Enrollment;
import com.JavaProject.Service.EnrollmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnrollmentControllerTest {

    private EnrollmentController enrollmentController;

    @Mock
    private EnrollmentService enrollmentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        enrollmentController = new EnrollmentController(enrollmentService);
    }

    @Test
    public void testInsertEnrollment() {
        Enrollment enrollment = new Enrollment();
        Mockito.when(enrollmentService.insertEnrollment(enrollment)).thenReturn("Enrollment added successfully");

        ResponseEntity<String> responseEntity = enrollmentController.insertEnrollment(enrollment);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Enrollment added successfully", responseEntity.getBody());
    }

    @Test
    public void testDeleteEnrollment() {
        Long enrollmentId = 1L;
        Mockito.when(enrollmentService.deleteEnrollment(enrollmentId)).thenReturn("Enrollment deleted successfully");

        ResponseEntity<String> responseEntity = enrollmentController.deleteEnrollment(enrollmentId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Enrollment deleted successfully", responseEntity.getBody());
    }
}
