package org.example.reporting.Controller;

import org.example.reporting.Dto.ReportDTO;
import org.example.reporting.Entity.Report;
import org.example.reporting.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping
    public Report createReport(@RequestBody ReportDTO dto) {
        return reportService.createReport(dto);
    }

    @GetMapping("/student/{studentId}")
    public ReportDTO getReportByStudentId(@PathVariable Long studentId) {
        return reportService.getReportByStudentId(studentId);
    }


    @GetMapping("/{id}")
    public Report getReport(@PathVariable Long id) {
        return reportService.getReportById(id);
    }
}
