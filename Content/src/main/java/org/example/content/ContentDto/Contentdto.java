package org.example.content.ContentDto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contentdto {
    private Long id;

    private Long CourseId;
    private String title;
    private String url;
    private String type;
    private Long StudentId;
    private Long InstructorId;
}
