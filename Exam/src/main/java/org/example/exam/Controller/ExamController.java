package org.example.exam.Controller;

import lombok.RequiredArgsConstructor;
import org.example.exam.Dto.ExamDTo;
import org.example.exam.Dto.ExamDetailsResponse;
import org.example.exam.Dto.InstructorDTO;
import org.example.exam.Dto.StudentDto;
import org.example.exam.Feign.InstructorClient;
import org.example.exam.Feign.StudentClient;
import org.example.exam.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
@RequiredArgsConstructor
public class ExamController {

    @Autowired
    private  ExamService examService;

    @Autowired
    private  StudentClient studentClient;

    @Autowired
    private  InstructorClient instructorClient;

    @GetMapping("/{id}")
    public ResponseEntity<ExamDetailsResponse> getExamDetails(@PathVariable Long id) {
        ExamDTo exam = examService.getExamById(id);

        StudentDto student = studentClient.getStudentById(exam.getStudentId());
        InstructorDTO instructor = instructorClient.getInstructorById(exam.getInstructorid());

        ExamDetailsResponse response = new ExamDetailsResponse();
        response.setExam(exam);
        response.setStudent(student);
        response.setInstructor(instructor);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ExamDTo>> getExamsByStudentId(@PathVariable Long studentId) {
        List<ExamDTo> exams = examService.getExamsByStudentId(studentId);
        return ResponseEntity.ok(exams);
    }

    @PostMapping
    public ResponseEntity<ExamDTo> createExam(@RequestBody ExamDTo examDto) {
        ExamDTo savedExam = examService.saveExam(examDto);
        return ResponseEntity.ok(savedExam);
    }
}
