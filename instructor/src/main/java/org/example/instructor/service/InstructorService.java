package org.example.instructor.service;

import org.example.instructor.dto.InstructorDTO;
import org.example.instructor.entity.Instructor;
import org.example.instructor.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public InstructorDTO createInstructor(InstructorDTO instructorDTO) {
        Instructor instructor = new Instructor();
        instructor.setName(instructorDTO.getName());
        instructor.setEmployeeId(instructorDTO.getEmployeeId());
        instructor.setEmail(instructorDTO.getEmail());
        instructor.setPhone(instructorDTO.getPhone());
        instructor.setCourse(instructorDTO.getCourse());

        Instructor saved = instructorRepository.save(instructor);

        InstructorDTO dto = new InstructorDTO();
        dto.setId(saved.getId());
        dto.setName(saved.getName());
        dto.setEmployeeId(saved.getEmployeeId());
        dto.setEmail(saved.getEmail());
        dto.setPhone(saved.getPhone());
        dto.setCourse(saved.getCourse());

        return dto;
    }

    public Optional<InstructorDTO> getInstructorById(Long id) {
        Optional<Instructor> optional = instructorRepository.findById(id);
        if (optional.isPresent()) {
            Instructor instructor = optional.get();
            InstructorDTO dto = new InstructorDTO();
            dto.setId(instructor.getId());
            dto.setName(instructor.getName());
            dto.setEmployeeId(instructor.getEmployeeId());
            dto.setEmail(instructor.getEmail());
            dto.setPhone(instructor.getPhone());
            dto.setCourse(instructor.getCourse());
            return Optional.of(dto);
        } else {
            return Optional.empty();
        }
    }
}
