package org.example.course.repository;

import org.example.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long>{
    List<Course> findByStudentId(Long studentId);

}
