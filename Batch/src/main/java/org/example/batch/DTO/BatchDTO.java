package org.example.batch.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchDTO {
    private Long id;
    private String name;
    private Long studentId;
    private Long instructorId;
    private Long courseId;
//    private List<Schedule> schedules;
//    private List<Attendance> attendances;
}
