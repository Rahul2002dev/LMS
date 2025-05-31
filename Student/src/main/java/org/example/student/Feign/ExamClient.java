package org.example.student.Feign;

import org.example.student.dto.ExamDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "exam-service",url = "http://localhost:8085")
public interface ExamClient {@GetMapping("/courses/student/{studentId}")
    List<ExamDTO> getExamsByStudentId(@PathVariable Long studentId);
}
