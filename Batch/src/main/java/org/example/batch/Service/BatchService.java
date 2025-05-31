package org.example.batch.Service;

import org.example.batch.DTO.*;
import org.example.batch.Entity.BatchEntity;
import org.example.batch.FeignClient.*;
import org.example.batch.Repository.BatchRepository;
import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchService {

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private StudentClient studentClient;

    @Autowired
    private InstructorClient instructorClient;

    @Autowired
    private CourseClient courseClient;

    public BatchDTO postBatch(BatchDTO batchDTO) {
        BatchEntity batch = new BatchEntity();
        batch.setId(batchDTO.getId());
        batch.setName(batchDTO.getName());
        batch.setStudentId(batchDTO.getStudentId());
        batch.setInstructorId(batchDTO.getInstructorId());
        batch.setCourseId(batchDTO.getCourseId());

        BatchEntity saved = batchRepository.save(batch);

        BatchDTO response = new BatchDTO();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setStudentId(saved.getStudentId());
        response.setInstructorId(saved.getInstructorId());
        response.setCourseId(saved.getCourseId());

        return response;
    }

    public BatchDTO getBatchByStudentId(Long studentId) {
        BatchEntity batch = batchRepository.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("Batch not found for student ID: " + studentId));

        BatchDTO dto = new BatchDTO();
        dto.setId(batch.getId());
        dto.setName(batch.getName());
        dto.setStudentId(batch.getStudentId());
        dto.setInstructorId(batch.getInstructorId());
        dto.setCourseId(batch.getCourseId());
        return dto;
    }


    public BatchDTO getBatchById(Long id) {
        BatchEntity batch = batchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        StudentDTo student = studentClient.getStudentById(batch.getStudentId());
        InstructorDTO instructor = instructorClient.getInstructorById(batch.getInstructorId());
        CouseDTO course = courseClient.getCourseById(batch.getCourseId());

        return new BatchDTO(
        );
    }
}
