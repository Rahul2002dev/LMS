package org.example.exam.Service;

import lombok.RequiredArgsConstructor;
import org.example.exam.Dto.ExamDTo;
import org.example.exam.Entity.Exam;
import org.example.exam.Repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    public ExamDTo getExamById(Long id) {
        Exam exam = examRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found with id: " + id));

        // Convert Entity to DTO
        ExamDTo dto = new ExamDTo();
        dto.setId(exam.getId());
        dto.setStudentId(exam.getStudentId());
        dto.setInstructorid(exam.getInstructorid());
        dto.setScore(exam.getScore());
        dto.setSubject(exam.getSubject());

        return dto;
    }

    public List<ExamDTo> getExamsByStudentId(Long studentId) {
        return examRepository.findByStudentId(studentId)
                .stream()
                .map(exam -> {
                    ExamDTo dto = new ExamDTo();
                    dto.setId(exam.getId());
                    dto.setStudentId(exam.getStudentId());
                    dto.setInstructorid(exam.getInstructorid());
                    dto.setScore(exam.getScore());
                    dto.setSubject(exam.getSubject());
                    return dto;
                })
                .collect(Collectors.toList());
    }





    public ExamDTo saveExam(ExamDTo examDto) {
        Exam exam = new Exam();
        exam.setStudentId(examDto.getStudentId());
        exam.setInstructorid(examDto.getInstructorid());
        exam.setScore(examDto.getScore());
        exam.setSubject(examDto.getSubject());

        Exam saved = examRepository.save(exam);

        return examDto;
    }
}
