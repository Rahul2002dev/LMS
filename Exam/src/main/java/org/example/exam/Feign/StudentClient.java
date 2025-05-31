package org.example.exam.Feign;

import org.example.exam.Dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Student", url = "${student.service.url}")
public interface StudentClient {
    @GetMapping("/students/{id}")
    StudentDto getStudentById(@PathVariable("id") Long id);
}
