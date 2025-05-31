package org.example.student.Feign;

import org.example.student.dto.BatchDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "batch-service",url = "http://localhost:9016")
public interface BatchClient {
    @GetMapping("/batches/student/{studentId}")
    BatchDTO getBatchByStudentId(@PathVariable Long studentId);
}
