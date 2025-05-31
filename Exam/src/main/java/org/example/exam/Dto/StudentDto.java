package org.example.exam.Dto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDto {
    private long id;

    private long User_id;
    private String firstName;
    private String lastName;

    private String batch;
    private String Course;
    private String Result;
}
