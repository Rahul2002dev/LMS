package org.example.reporting.Dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportDTO {
    private Long studentId;
    private String enrollmentStatus;
    private String result;
}
