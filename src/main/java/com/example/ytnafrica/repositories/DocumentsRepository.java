package com.example.ytnafrica.repositories;

import com.example.ytnafrica.models.Documents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsRepository extends JpaRepository<Documents, Long> {
}