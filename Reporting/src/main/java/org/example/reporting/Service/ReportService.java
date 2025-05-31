package org.example.reporting.Service;


import org.example.reporting.Dto.ReportDTO;
import org.example.reporting.Entity.Report;
import org.example.reporting.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public Report createReport(ReportDTO dto) {
        Report report = new Report();
        report.setStudentId(dto.getStudentId());
        report.setEnrollmentStatus(dto.getEnrollmentStatus());
        report.setResult(dto.getResult());
        return reportRepository.save(report);
    }

    public ReportDTO getReportByStudentId(Long studentId) {
        Report report = reportRepository.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("Report not found for studentId: " + studentId));

        ReportDTO dto = new ReportDTO();
        dto.setStudentId(report.getStudentId());
        dto.setEnrollmentStatus(report.getEnrollmentStatus());
        dto.setResult(report.getResult());
        return dto;
    }


    public Report getReportById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found with ID: " + id));
    }
}
