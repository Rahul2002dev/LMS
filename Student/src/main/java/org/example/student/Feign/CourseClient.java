package org.example.student.Feign;

import org.example.student.dto.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "course",url = "http://localhost:9093")
public interface CourseClient {
    @GetMapping("/api/courses/student/{studentId}")
    List<CourseDTO> getCourseByStudentId(@PathVariable Long studentId);
}
