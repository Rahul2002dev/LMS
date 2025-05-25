package org.example.content.ContentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentResponseDTO {
    private StudentDTo student;
    private CouseDTO course;
    private InstructorDTO instructor;
}
