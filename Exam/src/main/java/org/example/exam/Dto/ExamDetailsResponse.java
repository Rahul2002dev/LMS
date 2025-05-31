package org.example.exam.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamDetailsResponse {
    private ExamDTo exam;
    private StudentDto student;
    private InstructorDTO instructor;
}
