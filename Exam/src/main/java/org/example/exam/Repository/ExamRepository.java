package org.example.exam.Repository;

import org.example.exam.Entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam,Long> {
    List<Exam> findByStudentId(Long studentId);

}
