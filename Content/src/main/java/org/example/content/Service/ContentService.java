package org.example.content.Service;

import org.example.content.ContentDto.*;
import org.example.content.Entity.Content;
import org.example.content.FeignClient.CourseClient;
import org.example.content.FeignClient.InstructorClient;
import org.example.content.FeignClient.StudentClient;
import org.example.content.Reposistory.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {
    private final StudentClient studentClient;
    private final CourseClient courseClient;
    private final InstructorClient instructorClient;

    public ContentService(StudentClient studentClient, CourseClient courseClient, InstructorClient instructorClient) {
        this.studentClient = studentClient;
        this.courseClient = courseClient;
        this.instructorClient = instructorClient;
    }

    public ContentResponseDTO getFullContent(Long id) {
        StudentDTo student = studentClient.getStudentById(id);
        CouseDTO course = courseClient.getCourseById(id);
        InstructorDTO instructor = instructorClient.getInstructorById(id);

        return new ContentResponseDTO(student, course, instructor);
    }
}
