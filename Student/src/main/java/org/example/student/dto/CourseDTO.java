package org.example.student.dto;

import org.antlr.v4.runtime.misc.NotNull;

public class CourseDTO {
    private Long id;


    @NotNull
    private Long studentId;



    private String title;


    private String description;

    private int durationInHours;
}
