package org.example.instructor.repository;

import org.example.instructor.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long> {
}
