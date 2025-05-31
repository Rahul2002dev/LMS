package org.example.exam.Feign;



import org.example.exam.Dto.InstructorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "instructor", url = "${instructor.url}")
public interface InstructorClient {
    @GetMapping("/instructors/{id}")
    InstructorDTO getInstructorById(@PathVariable("id") Long id);
}
