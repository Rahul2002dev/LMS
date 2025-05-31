package org.example.exam.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamDTo {
    private long id;
    private long StudentId;
    private long instructorid;

    private int score;
    private String subject;
}
