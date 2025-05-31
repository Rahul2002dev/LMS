package org.example.student.dto;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private long userId;
    private String firstName;
    private String lastName;
    private String batch;
    private String course;
    private String result;
}
