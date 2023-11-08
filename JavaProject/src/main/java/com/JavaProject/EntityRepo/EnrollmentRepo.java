//EnrollmentRepo interface
package com.JavaProject.EntityRepo;
//importing neccessary packages

import org.springframework.data.jpa.repository.JpaRepository;

import com.JavaProject.Entity.Enrollment;
//creating a repo interface which extends JpaRepository

public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {
}
