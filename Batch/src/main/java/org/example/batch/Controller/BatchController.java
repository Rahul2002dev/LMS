package org.example.batch.Controller;

import org.example.batch.DTO.BatchDTO;
import org.example.batch.Service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/batches")
public class BatchController {

    @Autowired
    private BatchService batchService;


    @PostMapping
    public ResponseEntity<BatchDTO> createBatch(@RequestBody BatchDTO batchDTO){
        BatchDTO bat = batchService.postBatch(batchDTO);
        return ResponseEntity.ok().body(bat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BatchDTO> getBatchWithDetails(@PathVariable Long id) {
        BatchDTO batchDTO = batchService.getBatchById(id);
        return ResponseEntity.ok(batchDTO);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<BatchDTO> getBatchByStudentId(@PathVariable Long studentId) {
        BatchDTO batchDTO = batchService.getBatchByStudentId(studentId);
        return ResponseEntity.ok(batchDTO);
    }
}
