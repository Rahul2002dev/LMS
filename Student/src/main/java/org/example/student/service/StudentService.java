package org.example.student.service;
import org.example.student.Feign.*;
import org.example.student.dto.StudentDto;
import org.example.student.dto.StudentPofileDTO;
import org.example.student.entity.Student;
import org.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired private UserClient userClient;
    @Autowired private BatchClient batchClient;
    @Autowired private CourseClient courseClient;
    @Autowired private ExamClient examClient;
    @Autowired private NotificationClient notificationClient;
    @Autowired private ReportClient reportClient;

    public StudentPofileDTO getStudentFullProfile(Long studentId) {
        StudentPofileDTO profile = new StudentPofileDTO();

        profile.setUser(userClient.getUserById(studentId));
        profile.setBatch(batchClient.getBatchByStudentId(studentId));
        profile.setCourse(courseClient.getCourseByStudentId(studentId));
        profile.setExams(examClient.getExamsByStudentId(studentId));
        profile.setNotifications(notificationClient.getNotifications(studentId));
        profile.setReport(reportClient.getReportByStudentId(studentId));

        return profile;
    }

    public ResponseEntity<Student> studentPostService(StudentDto dto) {
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setBatch(dto.getBatch());
        student.setUser_id(dto.getUserId());
        student.setResult(dto.getResult());
        student.setCourse(dto.getCourse());

        studentRepository.save(student);

        return ResponseEntity.ok(student);
    }

    public ResponseEntity<Student> studentgetbyid(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Student> studentupdatedetails(long id , StudentDto dto ) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            Student stud = student.get();
            stud.setFirstName(dto.getFirstName());
            stud.setLastName(dto.getLastName());
            stud.setBatch(dto.getBatch());
            stud.setUser_id(dto.getUserId());
            stud.setResult(dto.getResult());
            stud.setCourse(dto.getCourse());
            studentRepository.save(stud);
        }else{
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student.get());
    }
}
