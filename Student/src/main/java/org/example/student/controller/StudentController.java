package org.example.student.controller;
import org.example.student.dto.StudentDto;
import org.example.student.entity.Student;
import org.example.student.repository.StudentRepository;
import org.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createstudent(@RequestBody StudentDto dto) {
        return studentService.studentPostService(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> studentGetService(@PathVariable long id) {
        return studentService.studentgetbyid(id);
    }

    @PutMapping
    public ResponseEntity<Student> updatestudent(@PathVariable long id , @RequestBody StudentDto dto ) {
        return studentService.studentupdatedetails(id,dto);
    }

}

