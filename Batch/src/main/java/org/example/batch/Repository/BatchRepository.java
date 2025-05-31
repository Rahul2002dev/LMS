package org.example.batch.Repository;


import org.example.batch.Entity.BatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BatchRepository extends JpaRepository<BatchEntity, Long> {
    Optional<BatchEntity> findByStudentId(Long studentId);
}
