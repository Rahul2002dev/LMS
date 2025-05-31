package org.example.student.Feign;

import org.example.student.dto.ResultDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "report-service",url = "http://localhost:9094")
public interface ReportClient {
    @GetMapping("/api/report/student/{studentId}")
    ResultDTO getReportByStudentId(@PathVariable Long studentId);
}
