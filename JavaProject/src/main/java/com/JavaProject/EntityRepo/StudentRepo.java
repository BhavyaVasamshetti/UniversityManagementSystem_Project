//StudentRepo interface
package com.JavaProject.EntityRepo;
//importing neccessary packages

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JavaProject.Entity.Student;
//creating a repo interface which extends JpaRepository

public interface StudentRepo extends JpaRepository<Student, Long> {
	// defining the findByMethods with the attribute names of the entity class

    Optional<Student> findByFirstName(String firstName);
    Optional<Student> findByLastName(String lastName);
    Optional<Student> findByEmail(String email);
}