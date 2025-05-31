package org.example.student.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentPofileDTO {
    private UserDTO user;
    private BatchDTO batch;
    private List<CourseDTO> course;
    private List<ExamDTO> exams;
    private List<NotificationDTO> notifications;
    private ResultDTO report;
}
